from collections import deque
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10001)
N = int(input())
graph = [list(map(int,input().split())) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]
island = -1

point = [[0,1],[1,0],[0,-1],[-1,0]]

def dfs(i,j,island):
    graph[i][j] = island
    visited[i][j] = 1
    for di,dj in point:
        ni,nj = i+di,j+dj
        if 0<=ni<N and 0<=nj<N and visited[ni][nj] == 0 :
            if graph[ni][nj] == 1 :
                dfs(ni,nj,island)

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1 :
            dfs(i,j,island)
            island -= 1

MIN = 10000
def bfs(i,j) :
    global MIN
    q = deque()
    q.append((i,j))
    visited[i][j] = 1
    while q :
        now = q.popleft()
        for di,dj in point :
            ni,nj =  now[0]+di, now[1] + dj
            if 0<=ni<N and 0<=nj<N and (visited[ni][nj] == 0 or visited[ni][nj] == 1):
                if graph[ni][nj] == 0 :
                    q.append((ni,nj))
                    visited[ni][nj] = visited[now[0]][now[1]] + 1
                elif graph[ni][nj] != graph[i][j] :
                    if visited[now[0]][now[1]] < MIN:
                        MIN = visited[now[0]][now[1]]

                    return MIN

lst = deque()
for i in range(N):
    for j in range(N):
        if graph[i][j] != 0 :
            for di,dj in point:
                ni,nj = i+di,j+dj
                if 0<=ni<N and 0<=nj<N and graph[ni][nj] == 0:
                    lst.append((i,j))
                    break
for i,j in lst :
    bfs(i,j)
    visited = [[0 for _ in range(N)] for _ in range(N)]
    for k,n in lst:
        visited[k][n] = 1

print(MIN-1)