from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
lst = list(map(int,input().split()))
ans = [0]*(len(lst) + 1)

for i in range(len(lst)):
    ans[i+1] = ans[i] + lst[i]

for _ in range(m):
    a,b = map(int,input().split())
    print(ans[b] - ans[a-1])
