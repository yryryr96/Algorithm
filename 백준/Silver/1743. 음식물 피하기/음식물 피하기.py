import sys
from collections import deque
input = sys.stdin.readline

n,m,k = map(int,input().split())
graph = [[0]*m for _ in range(n)]
visited = [[0]*m for _ in range(n)]
for _ in range(k):
    a,b = map(int,input().split())
    graph[a-1][b-1] = '#'

point = [[0,1],[1,0],[0,-1],[-1,0]]
ans = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == '#' and visited[i][j] == 0 :
            q = deque()
            q.append((i,j))
            visited[i][j] = 1
            cnt = 0
            while q :
                cnt += 1
                ans = max(ans,cnt)
                r,c = q.popleft()
                for di,dj in point :
                    ni,nj = r+di, c+dj
                    if 0<=ni<n and 0<=nj<m and graph[ni][nj] == '#' and visited[ni][nj] == 0 :
                        q.append((ni,nj))
                        visited[ni][nj] = 1

print(ans)