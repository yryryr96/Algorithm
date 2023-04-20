import sys
from itertools import combinations
input = sys.stdin.readline


lst = list(map(int,input().split()))
n = lst[0]
nowx,nowy = lst[1],lst[2]
bombx,bomby = lst[3],lst[4]

dx = bombx-nowx
dy = bomby-nowy
move_cnt = (dx+dy) // n
temp_move = (dx+dy) % n

if dx < 0 or dy < 0 :
    print(-1)
    exit()

a = 0
b = n
check = []
ans = []
while b >= 0 :
    k1 = a * move_cnt
    k2 = b * move_cnt
    if k1 > dx or k2 > dy :
        pass
    else :
        result = ""
        p1 = dx-k1
        p2 = dy-k2
        if p1 >= 0 and p2 >= 0 and a-p1>=0 and b-p2 >= 0 :
            result = 'R' * (p1) + 'U' * (p2) + 'R' * (a - p1) + 'U' * (b - p2)
            check.append((a-p1,b-p2,p1,p2))
            ans.append(result)
    a+=1
    b-=1

ans.sort()
if not check:
    print(-1)
else:
    print(ans[0])

