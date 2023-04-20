import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]
def bfs():
    global ans

    q_zero = deque()
    visited_zero = [[0]*m for _ in range(n)]
    q_zero.append((0,0))
    visited_zero[0][0] = 1
    q_one = deque()
    while q_zero :
        i,j = q_zero.popleft()
        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m and visited_zero[ni][nj] == 0 :
                if graph[ni][nj] == 0 :
                    q_zero.append((ni,nj))
                    visited_zero[ni][nj] = 1
                elif graph[ni][nj] == 1 :
                    visited_zero[ni][nj] = -1
                    q_one.append((ni,nj))

    check = []
    while q_one :
        i,j = q_one.popleft()
        cnt = 0
        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m and visited_zero[ni][nj] == 1 :
                cnt += 1

        if cnt >= 2 :
            check.append((i,j))

    for i,j in check:
        graph[i][j] = 0
        ans -= 1

    return

ans = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 :
            ans += 1

c = 0;

while True :
    c += 1
    bfs()
    # for i in range(n):
    #     print(*graph[i])
    # print("##############")
    if ans == 0 :
        break


print(c)