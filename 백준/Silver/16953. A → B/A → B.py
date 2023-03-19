import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())

q = deque()
q.append((n,1))
cnt = 0
temp = 0
while q:
    now, cnt = q.popleft()
    
    if now == m :
        temp = 1
        break

    for num in [int(str(now) + str(1)),now*2] :
        if num <= m :
            q.append((num,cnt+1))


if temp == 1:
    print(cnt)
else :
    print(-1)

