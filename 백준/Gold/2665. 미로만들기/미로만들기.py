import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [input().rstrip() for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
cnt = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == '0' :
            cnt += 1

visited = [[[-1]*n for _ in range(n)] for _ in range(cnt+1)]
q = deque()
q.append((0,0,0))
visited[0][0][0] = 0

while q:
    i,j,wc = q.popleft()
    # print(i,j)
    if i == n-1 and j == n-1 :
        print(wc)
        break

    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<n and 0<=nj<n and visited[wc][ni][nj] == -1 :
            if graph[ni][nj] == '1' :
                q.appendleft((ni,nj,wc))
                visited[wc][ni][nj] = 0
            else :
                q.append((ni,nj,wc+1))
                visited[wc+1][ni][nj] = 0
