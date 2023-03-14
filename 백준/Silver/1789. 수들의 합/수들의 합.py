import sys
input = sys.stdin.readline

n = int(input())

i = 1
check = 0
while True :
    check += i

    if check > n :
        print(i-1)
        break

    elif check == n :
        print(i)
        break
    i+=1