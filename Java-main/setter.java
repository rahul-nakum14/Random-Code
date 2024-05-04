class setter {
    private int eid;

    public void seteid(int x){
        this.eid = x;
    }

    public int getid(){
        return eid;
    }
}
class tes1{
    public static void main(String[] args) {
        setter obj = new setter();
        obj.seteid(50000);
        System.out.println(obj.getid());
    }
}
