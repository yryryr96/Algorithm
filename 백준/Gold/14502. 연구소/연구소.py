from itertools import combinations
from collections import deque
from copy import deepcopy
import sys
input = sys.stdin.readline

def bfs():
    q = deque(Q)
    visited = [[0]*m for _ in range(n)]
    for k,l in q :
        visited[k][l] = 1

    while q :
        now = q.popleft()
        for di,dj in point :
            ni,nj = now[0] + di, now[1] + dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 and temp[ni][nj] == 0 :
                visited[ni][nj] = 1
                temp[ni][nj] = 2
                q.append((ni,nj))

    cnt = 0
    for i in range(n) :
        for j in range(m):
            if temp[i][j] == 0 :
                cnt += 1
    return cnt

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
Q = []
check = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0 :
            check.append((i,j))
        elif graph[i][j] == 2 :
            Q.append((i,j))

MAX = 0
for p in combinations(check,3):
    temp = deepcopy(graph)
    for row,col in p :
        temp[row][col] = 1
    ans = bfs()
    MAX = max(MAX,ans)

print(MAX)