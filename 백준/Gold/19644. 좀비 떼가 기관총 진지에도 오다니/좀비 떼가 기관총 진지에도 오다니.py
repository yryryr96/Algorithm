import sys
from collections import deque
input = sys.stdin.readline

L = int(input()) # 거리 ( zombie index )
gun_d, damage = map(int,input().split()) # 기관총 유효 사거리, 데미지
bomb_cnt = int(input()) # 1번 index 킬
zombie = [0]*(L+1)
q = deque()
cq = deque()

for i in range(1,L+1):
    zombie[i] = int(input())

for i in range(1,min(L+1,gun_d+1)) :
    q.append((i,i))

while q :
    s = q[0][0]
    d = q[0][1]
    if zombie[s] <= damage*(d-len(cq)) :
        # print(zombie[s],damage*(d-len(cq)))
        q.popleft()
    else :
        if bomb_cnt :
            bomb_cnt -= 1
            cq.append(s+gun_d-1)
            q.popleft()
        else :
            print("NO")
            break

    if s + gun_d <= L: q.append((s + gun_d, len(q)+1))
    if cq and s == cq[0] : cq.popleft()
else :
    print("YES")




# 3 6 100 6 9 -> 3 97 6 9 -> 94 3 9 -> 3 9 -> 6

# 1번 index 좀비 못죽이면 die
# 1번 index 좀비의 피가 damage보다 작으면 기관총
# damage보다 크면 폭탄 -> 폭탄 없으면 die
# L 10^6, gun_d 10^6, bomb_cnt 10^6
