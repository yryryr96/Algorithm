import sys
from collections import deque
input = sys.stdin.readline

n,m,k = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(n)]
point = [[1,0],[0,1],[-1,0],[0,-1]]
visited = [[0]*m for _ in range(n)]
x1,y1,x2,y2 = map(int,input().split())
x1-=1;y1-=1;x2-=1;y2-=1
q = deque()
q.append((x1,y1))
visited[x1][y1] = 1
while q:
    i,j = q.popleft()
    for di,dj in point :
        for l in range(1,k+1) :
            ni,nj = i+di*l,j+dj*l

            if ni<0 or ni>=n or nj<0 or nj>=m :
                break

            if graph[ni][nj] == '#' :
                break
            if visited[ni][nj]!= 0 and visited[ni][nj] < visited[i][j] + 1:
                break

            if visited[ni][nj] == 0 or visited[ni][nj] > visited[i][j] + 1 :
                visited[ni][nj] = visited[i][j] + 1
                q.append((ni,nj))

if visited[x2][y2] == 0 :
    print(-1)
else :
    ans = visited[x2][y2] - 1
    print(ans)
