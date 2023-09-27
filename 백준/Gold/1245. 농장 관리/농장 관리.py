import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
point = [(1,0),(0,1),(-1,0),(0,-1),(1,1),(1,-1),(-1,1),(-1,-1)]

matrix = []
for i in range(n):
    for j in range(m):
        matrix.append((graph[i][j],i,j))

matrix.sort(key = lambda x : -x[0])
def bfs(i,j) :
    global ans

    q = deque()
    q.append((i,j))

    temp = 1
    while q :
        r,c = q.popleft()
        for di,dj in point :
            ni, nj = r+di, c+dj
            if not (0<=ni<n and 0<=nj<m) : continue
            if graph[ni][nj] == graph[i][j] and visited[ni][nj] == 0 :
                q.append((ni,nj))
                visited[ni][nj] = 1

            elif graph[ni][nj] > graph[i][j] :
                temp = 0

    if temp == 1 :
        ans += 1
        # print(i,j)

def check(i,j,c):
    for di,dj in point :
        ni,nj = i+di, j+dj
        if not (0<=ni<n and 0<=nj<m) : continue
        if graph[ni][nj] > c : return False

    return True

ans = 0
for i in range(n) :
    for j in range(m) :
        if graph[i][j] != 0 and visited[i][j] == 0 :
            bfs(i,j)

print(ans)


# for i in range(n):
#     print(*visited[i])
#
