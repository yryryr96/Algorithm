from collections import deque
import sys
input = sys.stdin.readline

M,N,H = map(int,input().split())
graph = []
q = deque()

for i in range(H):
    temp = []
    for j in range(N):
        temp.append(list(map(int,input().split())))
        for k in range(M):
            if temp[j][k] == 1:
                q.append((k,j,i))
    graph.append(temp)

dx = [-1,1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,1,-1]

while q:
    x,y,z = q.popleft()

    for i in range(6):
        nx = x+dx[i]
        ny = y+dy[i]
        nz = z+dz[i]
        if 0 <= nx < M and 0<=ny < N and 0<=nz<H and graph[nz][ny][nx] == 0 :
            q.append((nx,ny,nz))
            graph[nz][ny][nx] = graph[z][y][x] + 1

ans = 0
for i in range(H):
    for j in range(N):
        for k in range(M):
            if graph[i][j][k] == 0 :
                print(-1)
                exit(0)
            else :
                if ans < graph[i][j][k] :
                    ans = graph[i][j][k]
print(ans-1)