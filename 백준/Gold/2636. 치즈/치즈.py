import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]
ans = 0

def bfs():
    global ans
    visited = [[0]*m for _ in range(n)]
    q = deque()
    q.append((0,0))
    visited[0][0] = 1
    edges = []

    while q:
        i,j = q.popleft()
        for di,dj in point :
            ni,nj = i+di,j+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 :
                visited[ni][nj] = 1
                if graph[ni][nj] == 0 :
                    q.append((ni,nj))
                elif graph[ni][nj] == 1 :
                    edges.append((ni,nj))

    for i,j in edges:
        graph[i][j] = 0
        ans -= 1

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 :
            ans += 1

cnt = 0
temp = ans
while True :
    cnt += 1
    bfs()
    if ans == 0 :
        break
    temp = ans

print(cnt)
print(temp)