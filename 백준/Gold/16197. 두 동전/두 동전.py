import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
visited = [[[[0] * (m+1) for _ in range(n+1)] for _ in range(m+1)] for _ in range(n+1)]
coin = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'o' :
            coin.append((i,j,0))
# print(coin)
q = deque([coin])
# print(coin)
while q :
    c1,c2 = q.popleft()
    # print(c1,c2)
    if (0>c1[0] or c1[0] >= n or c1[1] < 0 or c1[1] >=m) and (0>c2[0] or c2[0] >= n or c2[1] < 0 or c2[1] >=m) : continue
    elif (0>c1[0] or c1[0] >= n or c1[1] < 0 or c1[1] >=m) :
        print(c1[2])
        break
    elif (0>c2[0] or c2[0] >= n or c2[1] < 0 or c2[1] >=m) :
        print(c2[2])
        break
    else :
        for di,dj in point :
            ni,nj = c1[0]+di, c1[1]+dj
            ki,kj = c2[0]+di, c2[1]+dj
            if c1[2] == 10 :
                continue
            coin = []
            if 0<=ni<n and 0<=nj<m and graph[ni][nj] == '#' :
                coin.append((c1[0],c1[1],c1[2]+1))
            else :
                coin.append((ni,nj,c1[2]+1))

            if 0<=ki<n and 0<=kj<m and graph[ki][kj] == '#' :
                coin.append((c2[0],c2[1],c2[2]+1))
            else :
                coin.append((ki,kj,c2[2]+1))

            if not visited[coin[0][0]][coin[0][1]][coin[1][0]][coin[1][1]] :
                visited[coin[0][0]][coin[0][1]][coin[1][0]][coin[1][1]] = 1
                q.append(coin)
else :
    print(-1)


