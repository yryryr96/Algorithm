import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split())
lst = deque(list(range(1,N+1)))

point = list(map(int,input().split()))
cnt = 0
for n in point :
    while lst[0] != n:
        if lst.index(n) > len(lst)/2 :
            lst.appendleft(lst.pop())
            cnt += 1
        else :
            lst.append(lst.popleft())
            cnt += 1
    lst.popleft()
print(cnt)
