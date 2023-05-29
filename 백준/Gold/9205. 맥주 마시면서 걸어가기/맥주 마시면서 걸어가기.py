import sys
from collections import deque
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n = int(input())
    q = deque()

    hx,hy = map(int,input().split())
    q.append((hx,hy))
    check = []
    for _ in range(n):
        x,y = map(int,input().split())
        check.append((x,y))
    fx,fy = map(int,input().split())
    while q :
        x,y = q.popleft()
        if abs(x-fx) + abs(y-fy) <= 1000 :
            print('happy')
            break
        for i,j in check :
            if abs(x-i) + abs(y-j) <= 1000 :
                check.remove((i,j))
                q.append((i,j))
    else :
        print('sad')