import sys
from collections import deque
input = sys.stdin.readline

ph = [[-1,-2],[-2,-1],[-2,1],[-1,2],[1,-2],[2,-1],[2,1],[1,2]]
point = [[0,1],[1,0],[0,-1],[-1,0]]

k = int(input())
m,n = map(int,input().split())
visited = [[[0]*(k+1) for _ in range(m)] for _ in range(n)]
graph = [list(map(int,input().split())) for _ in range(n)]

q = deque()
q.append((0,0,0))
visited[0][0][0] = 1

while q :
    i,j,cnt = q.popleft()

    if i == n-1 and j == m-1 :
        print(visited[i][j][cnt] - 1)
        break

    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<n and 0<=nj<m and visited[ni][nj][cnt] == 0 and graph[ni][nj] == 0 :
            q.append((ni,nj,cnt))
            visited[ni][nj][cnt] = visited[i][j][cnt] + 1

    if cnt < k :
        for di,dj in ph :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj][cnt+1] == 0 and graph[ni][nj] == 0:
                q.append((ni,nj,cnt+1))
                visited[ni][nj][cnt+1] = visited[i][j][cnt] + 1

else :
    print(-1)