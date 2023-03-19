from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [input().rstrip() for _ in range(n)]
MAX = 0
def bfs(i,j):
    global MAX
    point = [[0,1],[1,0],[0,-1],[-1,0]]
    visited =[[0]*m for _ in range(n)]
    visited[i][j] = 1
    q = deque()
    q.append((i,j))
    while q:
        now = q.popleft()
        if MAX < visited[now[0]][now[1]] :
            MAX = visited[now[0]][now[1]] - 1

        for di,dj in point :
            ni,nj = now[0] + di, now[1] + dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 and graph[ni][nj] == 'L' :
                q.append((ni,nj))
                visited[ni][nj] = visited[now[0]][now[1]] + 1
    return

for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L':
            if i-1 >= 0 and i+1 < n :
                if graph[i-1][j] == "L" and graph[i+1][j] == "L" :
                    continue
            if j-1 >= 0 and j+1 < m :
                if graph[i][j-1] == "L" and graph[i][j+1] == "L" :
                    continue
            bfs(i,j)
print(MAX)