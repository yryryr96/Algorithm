from collections import deque
import sys
input = sys.stdin.readline
M,N = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]
day = []
q = deque()
point = [[0,1],[1,0],[-1,0],[0,-1]]

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            q.append((i,j))
            visited[i][j] = 1

while q:
    now = q.popleft()

    for di,dj in point :
        ni, nj = now[0]+di, now[1]+dj
        if 0<=ni<N and 0<=nj<M and visited[ni][nj] == 0 and graph[ni][nj] == 0 :
            graph[ni][nj] = 1
            visited[ni][nj] = visited[now[0]][now[1]] + 1
            day.append(visited[ni][nj])
            q.append((ni,nj))
temp = 1
for i in graph :
    if 0 in i :
        temp = 0

if temp == 0 :
    print(-1)
elif not day:
    print(0)
else:
    print(max(day)-1)