import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]
point = [[0,1],[1,0],[-1,0],[0,-1],[1,1],[1,-1],[-1,1],[-1,-1]]

q = deque()
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1 :
            q.append((i,j))
            visited[i][j] = 1

ans = 0
while q :
    now = q.popleft()

    for di,dj in point :
        ni,nj = now[0]+di, now[1]+dj
        if 0<=ni<N and 0<=nj<M and visited[ni][nj] == 0 :
            if graph[ni][nj] == 0 :
                visited[ni][nj] = visited[now[0]][now[1]] + 1
                q.append((ni,nj))
                ans = max(ans,visited[ni][nj]-1)

print(ans)