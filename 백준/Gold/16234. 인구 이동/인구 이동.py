import sys
from collections import deque
input = sys.stdin.readline

n,L,R = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]

def bfs(i,j):
    global temp
    q = deque()
    q.append((i, j))
    visited[i][j] = 1
    lst = [(i,j)]
    SUM = graph[i][j]

    while q:
        row, col = q.popleft()
        for di, dj in point:
            ni, nj = row + di, col + dj
            if 0 <= ni < n and 0 <= nj < n and visited[ni][nj] == 0 and L <= abs(graph[row][col] - graph[ni][nj]) <= R:
                lst.append((ni, nj))
                visited[ni][nj] = 1
                SUM += graph[ni][nj]
                q.append((ni, nj))

    length = len(lst)
    if length == 1 :
        return
    else:
        for row,col in lst:
            graph[row][col] = int(SUM//length)
        temp = 1
        return
cnt = 0
while True :
    temp = 0
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 :
                bfs(i,j)

    if temp == 0 :
        break
    else :
        cnt+=1
        continue

print(cnt)

