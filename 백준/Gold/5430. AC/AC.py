import sys
from collections import deque

T = int(input())
for tc in range(1, T + 1):
    p = deque(input())
    n = int(input())
    lst = deque((input()[1:-1].split(',')))

    cnt = 0
    temp = 1
    while p:
        if p[0] == 'R':
            cnt += 1
            p.popleft()

        elif p[0] == 'D':
            p.popleft()

            if lst :
                if cnt % 2 == 0:
                    k = lst.popleft()
                    if k == '':
                        temp = 0
                        break
                else:
                    k = lst.pop()
                    if k == '' :
                        temp = 0
                        break
            else:
                temp = 0
                break
    if temp == 0 :
        print('error')
    else:
        if cnt%2 == 0 :
            print('[',end='')
            print(','.join(lst),end='')
            print(']')
        else :
            print('[', end='')
            print(','.join(reversed(lst)), end='')
            print(']')