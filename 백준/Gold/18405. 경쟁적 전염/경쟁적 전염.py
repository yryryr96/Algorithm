import sys
from collections import deque
input = sys.stdin.readline

N,K = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
visited = [[-1]*N for _ in range(N)]
point = [[0,1],[1,0],[0,-1],[-1,0]]

viruses = []
for i in range(N):
    for j in range(N):
        if graph[i][j] :
            viruses.append((graph[i][j],i,j))
            visited[i][j] = 0

S,X,Y = map(int,input().split())
viruses.sort()
q = deque(viruses)

while q:
    num, i, j = q.popleft()

    if visited[i][j] == S :
        continue

    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<N and 0<=nj<N and graph[ni][nj] == 0 and visited[ni][nj] == -1 :
            graph[ni][nj] = num
            visited[ni][nj] = visited[i][j] + 1
            q.append((graph[ni][nj],ni,nj))


if graph[X-1][Y-1] :
    print(graph[X-1][Y-1])
else :
    print(0)