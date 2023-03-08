from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
graph = [list(map(int,input().split())) for _ in range(N)]
shark = 2
point = [[0,1],[1,0],[0,-1],[-1,0]]

for i in range(N):
    for j in range(N):
        if graph[i][j] == 9 :
            graph[i][j] = 0
            now = (i,j)

ans = 0
cnt = 0
while True:
    lst = []
    visited = [[0 for _ in range(N)] for _ in range(N)]
    q = deque()
    q.append(now)
    visited[now[0]][now[1]] = 1
    while q :
        now = q.popleft()
        for di,dj in point :
            ni,nj = now[0]+di, now[1]+dj
            if 0<=ni<N and 0<=nj<N and visited[ni][nj] == 0 and graph[ni][nj] <= shark :
                q.append((ni,nj))
                visited[ni][nj] = visited[now[0]][now[1]] + 1

                if 0 < graph[ni][nj] < shark :
                    lst.append([visited[ni][nj],ni,nj])

    if not lst :
        break

    lst.sort(key=lambda x: (x[0], x[1], x[2]))
    graph[lst[0][1]][lst[0][2]] = 0
    now = (lst[0][1], lst[0][2])
    cnt += 1
    if cnt == shark :
        shark += 1
        cnt = 0
    ans += lst[0][0] - 1

print(ans)
