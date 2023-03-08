import sys
from collections import deque

T = int(input())
for tc in range(T):
    N,M = map(int,input().split())
    P = list(map(int,input().split()))
    lst = list(range(1,N+1))
    lst[M] = 'A'
    cnt = 0
    while lst:
        if P[0] == max(P) :
            cnt += 1
            if lst.pop(0) == 'A' :
                print(cnt)
                break
            P.pop(0)

        else :
            lst.append(lst.pop(0))
            P.append(P.pop(0))


