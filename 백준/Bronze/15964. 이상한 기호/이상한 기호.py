import sys
input = sys.stdin.readline
a,b = map(int,input().split())
ans = (a+b)*(a-b)
print(ans)