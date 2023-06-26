import sys
from collections import deque

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]

picture = 0
ans = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] and visited[i][j] == 0 :
            q = deque()
            visited[i][j] = 1
            q.append((i,j))
            picture += 1
            cnt = 0
            while q :
                r,c = q.popleft()
                cnt += 1
                ans = max(cnt,ans)
                for di,dj in point :
                    ni,nj = r+di, c+dj
                    if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 and graph[ni][nj]:
                        visited[ni][nj] = 1
                        q.append((ni,nj))
print(picture)
print(ans)