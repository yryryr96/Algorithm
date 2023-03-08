from collections import deque
point = [[0,1],[1,0],[-1,0],[0,-1]]
home = 1
ans = []
def dfs(i,j):
    global home
    visited[i][j] = 1
    graph[i][j] = 0
    for di,dj in point:
        ni, nj = i+di, j+dj
        if 0<= ni < N and 0<= nj < N and visited[ni][nj] == 0 and graph[ni][nj] == 1:
            home += 1
            dfs(ni,nj)
    return home

N = int(input())
graph = [list(map(int,input())) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]
island = 0

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            island += 1
            ans.append(dfs(i,j))
            home = 1
ans.sort()
print(island)
for i in ans :
    print(i)
