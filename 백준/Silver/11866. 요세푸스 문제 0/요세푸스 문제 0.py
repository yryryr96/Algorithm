import sys
from collections import deque

N,K = map(int,input().split())
q = list(range(1,N+1))
ans = []

i = K-1
while q:
    if i >= len(q):
        i = i%len(q)

    ans.append(q.pop(i))
    i = i+K-1   # 하나가 삭제되므로 -1

ans = list(map(str,ans))
print(f'<{", ".join(ans)}>')