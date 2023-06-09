import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[-1]*m for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
q = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2 :
            q.append((i,j))
            visited[i][j] = 0
        elif graph[i][j] == 0 :
            visited[i][j] = 0

while q:
    i,j = q.popleft()
    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<n and 0<=nj<m and visited[ni][nj] == -1 :
            q.append((ni,nj))
            visited[ni][nj] = visited[i][j] + 1

for i in range(n):
    print(*visited[i])
