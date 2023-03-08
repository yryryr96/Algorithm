import sys
input = sys.stdin.readline
M,N = map(int,input().split())
lst = list(range(M,N+1))
ans = []
for number in range(M,N+1) :
    check = 1
    for i in range(2,int(pow(number,0.5))+1):
        if number % i == 0 :
            check = 0
            break
    if check and number != 1:
        print(number)


