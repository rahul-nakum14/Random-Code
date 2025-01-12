# hubspot.py

import json
import secrets
from fastapi import Request, HTTPException
from fastapi.responses import HTMLResponse
import httpx
import asyncio
import base64
from integrations.integration_item import IntegrationItem
from redis_client import add_key_value_redis, get_value_redis, delete_key_redis

CLIENT_ID = '268bd044-f8ca-41e0-a49d-8da06e3bbaf0'
CLIENT_SECRET = '74c0121f-bad6-4e35-aa16-0dde84be086e'
REDIRECT_URI = 'http://localhost:8000/integrations/hubspot/oauth2callback'
authorization_url = f'https://app.hubspot.com/oauth/authorize?client_id={CLIENT_ID}&redirect_uri={REDIRECT_URI}&scope=contacts%20content'

async def authorize_hubspot(user_id, org_id):
    state_data = {
        'state': secrets.token_urlsafe(32),
        'user_id': user_id,
        'org_id': org_id
    }
    encoded_state = base64.urlsafe_b64encode(json.dumps(state_data).encode('utf-8')).decode('utf-8')
    
    await add_key_value_redis(f'hubspot_state:{org_id}:{user_id}', json.dumps(state_data), expire=600)
    
    return f'{authorization_url}&state={encoded_state}'

async def oauth2callback_hubspot(request: Request):
    if request.query_params.get('error'):
        raise HTTPException(status_code=400, detail=request.query_params.get('error'))
    
    code = request.query_params.get('code')
    encoded_state = request.query_params.get('state')
    state_data = json.loads(base64.urlsafe_b64decode(encoded_state).decode('utf-8'))
    
    original_state = state_data.get('state')
    user_id = state_data.get('user_id')
    org_id = state_data.get('org_id')
    
    saved_state = await get_value_redis(f'hubspot_state:{org_id}:{user_id}')
    
    if not saved_state or original_state != json.loads(saved_state).get('state'):
        raise HTTPException(status_code=400, detail='State does not match.')
    
    async with httpx.AsyncClient() as client:
        response, _ = await asyncio.gather(
            client.post(
                'https://api.hubapi.com/oauth/v1/token',
                data={
                    'grant_type': 'authorization_code',
                    'client_id': CLIENT_ID,
                    'client_secret': CLIENT_SECRET,
                    'redirect_uri': REDIRECT_URI,
                    'code': code
                }
            ),
            delete_key_redis(f'hubspot_state:{org_id}:{user_id}'),
        )
    
    await add_key_value_redis(f'hubspot_credentials:{org_id}:{user_id}', json.dumps(response.json()), expire=600)
    
    close_window_script = """
    <html>
        <script>
            window.close();
        </script>
    </html>
    """
    return HTMLResponse(content=close_window_script)

async def get_hubspot_credentials(user_id, org_id):
    credentials = await get_value_redis(f'hubspot_credentials:{org_id}:{user_id}')
    if not credentials:
        raise HTTPException(status_code=400, detail='No credentials found.')
    credentials = json.loads(credentials)
    await delete_key_redis(f'hubspot_credentials:{org_id}:{user_id}')
    
    return credentials

async def create_integration_item_metadata_object(response_json):
    # TODO
    pass

async def get_items_hubspot(credentials) -> list[IntegrationItem]:
    credentials = json.loads(credentials)
    access_token = credentials.get('access_token')
    
    headers = {
        'Authorization': f'Bearer {access_token}',
        'Content-Type': 'application/json'
    }
    
    integration_items = []
    
    # Fetch contacts
    contacts_response = requests.get('https://api.hubapi.com/crm/v3/objects/contacts', headers=headers)
    if contacts_response.status_code == 200:
        contacts = contacts_response.json().get('results', [])
        for contact in contacts:
            integration_items.append(IntegrationItem(
                id=contact['id'],
                type='contact',
                name=contact['properties'].get('firstname', '') + ' ' + contact['properties'].get('lastname', ''),
                creation_time=contact['createdAt'],
                last_modified_time=contact['updatedAt']
            ))
    
    # Fetch deals
    deals_response = requests.get('https://api.hubapi.com/crm/v3/objects/deals', headers=headers)
    if deals_response.status_code == 200:
        deals = deals_response.json().get('results', [])
        for deal in deals:
            integration_items.append(IntegrationItem(
                id=deal['id'],
                type='deal',
                name=deal['properties'].get('dealname', ''),
                creation_time=deal['createdAt'],
                last_modified_time=deal['updatedAt']
            ))
    
    # Fetch companies
    companies_response = requests.get('https://api.hubapi.com/crm/v3/objects/companies', headers=headers)
    if companies_response.status_code == 200:
        companies = companies_response.json().get('results', [])
        for company in companies:
            integration_items.append(IntegrationItem(
                id=company['id'],
                type='company',
                name=company['properties'].get('name', ''),
                creation_time=company['createdAt'],
                last_modified_time=company['updatedAt']
            ))
    
    print(f'HubSpot Integration Items: {integration_items}')
    return integration_items