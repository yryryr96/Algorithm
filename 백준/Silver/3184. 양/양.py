import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [input().rstrip() for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
visited = [[0]*m for _ in range(n)]

lamb = wolf = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'o' : lamb+=1
        elif graph[i][j] == 'v' : wolf += 1

def bfs(r,c):
    global lamb,wolf
    visited[r][c] = 1
    q = deque()
    q.append((r,c))
    w = 0
    l = 0
    while q :
        i,j = q.popleft()
        if graph[i][j] == 'o' : l += 1
        elif graph[i][j] == 'v' : w += 1

        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 :
                if graph[ni][nj] != '#' :
                    q.append((ni,nj))
                    visited[ni][nj] = 1
    # print(i,j,w,l)
    if w >= l : lamb -= l
    else : wolf -= w

    return

for i in range(n):
    for j in range(m):
        if (graph[i][j] == 'v' or graph[i][j] == 'o')  and visited[i][j] == 0 :
            bfs(i,j)

print(lamb, wolf)