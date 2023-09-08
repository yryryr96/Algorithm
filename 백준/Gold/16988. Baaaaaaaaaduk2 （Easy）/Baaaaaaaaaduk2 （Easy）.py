import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [(0,1),(1,0),(0,-1),(-1,0)]
temp = []

for i in range(n) :
    for j in range(m):
        if graph[i][j] == 0 :
            temp.append((i,j))

ans = 0
for p in combinations(temp,2) :
    for i,j in p :
        graph[i][j] = 1

    visited = [[0]*m for _ in range(n)]
    part = [0]*401
    cnt = 0
    tmp = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2 and visited[i][j] == 0:
                q = deque()
                q.append((i,j))
                visited[i][j] = 1
                part[cnt] = 1

                while q :
                    r,c = q.popleft()
                    for di,dj in point :
                        ni,nj = r+di, c+dj
                        if not (0<=ni<n and 0<=nj<m) or visited[ni][nj] != 0 : continue
                        if graph[ni][nj] == 2 :
                            if part[cnt] != -1 :
                                part[cnt] += 1

                            q.append((ni, nj))
                            visited[ni][nj] = 1

                        elif graph[ni][nj] == 0 :
                            part[cnt] = -1
                            q.append((ni,nj))
                            visited[ni][nj] = 1


                if part[cnt] != -1 : tmp += part[cnt]
                cnt += 1

    ans = max(tmp, ans)
    for i, j in p:
        graph[i][j] = 0

print(ans)