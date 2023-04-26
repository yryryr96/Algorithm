import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
visited = [[0]*m for _ in range(n)]
dic = {}
def bfs(i,j,numbering):
    q = deque()
    q.append((i,j))
    cnt = 1
    while q :
        r,c = q.popleft()
        for di,dj in point :
            ni,nj = r+di, c+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 and graph[ni][nj] == 0 :
                visited[ni][nj] = 1
                cnt += 1
                graph[ni][nj] = numbering
                q.append((ni,nj))

    dic[numbering] = cnt

k = 2
check = []
for i in range(n):
    for j in range(m):
        graph[i][j] = int(graph[i][j])
        if graph[i][j] == 1 :
            check.append((i,j))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0 :
            graph[i][j] = k
            visited[i][j] = 1
            bfs(i,j,k)
            k+=1

temp = [[0]*m for _ in range(n)]
for i,j in check :
    SUM = 1
    visited_c = set()
    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<n and 0<=nj<m and graph[ni][nj] != 1:
            visited_c.add(graph[ni][nj])
    for num in visited_c :
        SUM += dic[num]
    temp[i][j] = SUM

for i in range(n):
    for j in range(m):
        print(temp[i][j]%10,end="")
    print()

