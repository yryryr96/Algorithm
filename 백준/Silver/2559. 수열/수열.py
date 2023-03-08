import sys
from collections import deque
input = sys.stdin.readline

N,K = map(int,input().split())
lst = list(map(int,input().split()))
ans = []

ans.append(sum(lst[:K]))
for i in range(N-K):
    ans.append(ans[i] - lst[i] + lst[K+i])

print(max(ans))