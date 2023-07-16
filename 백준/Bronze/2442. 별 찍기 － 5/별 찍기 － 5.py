import sys
input = sys.stdin.readline

n = int(input())
ans = []
for i in range(1,n+1):
    temp = ' '*(n-i) + '*'*(2*i-1)
    print(temp)
