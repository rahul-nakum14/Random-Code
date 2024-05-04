def palindrome(s):
    right =len(s) -1
    left = 0

    while left<right:
        if s[left] != s[right]:
            return 'Not palindrome'
        left+=1
        right-=1

    return 'Palindrome'

s = 'abcba'
print(palindrome(s))




# n = 19
# n1 , n2 = 0, 1
# for i in range(2,n):
#     n3 = n1 + n2
#     n1 = n2
#     n2 = n3
#     print(n3)

# def is_prime(n):
#     if n <= 1:
#         return False
#     for i in range(2 , n//2):
#         if n%i==0:
#             return False
#     return True

# n = 22

# for i in range(15):
#     if (is_prime(i)):
#         print(i)



# num = 10
# n1, n2 = 0, 1
# print("Fibonacci Series:", n1, n2, end=" ")
# for i in range(2, num):
#     n3 = n1 + n2
#     n1 = n2
#     n2 = n3
#     print(n3, end=" ")

# print()