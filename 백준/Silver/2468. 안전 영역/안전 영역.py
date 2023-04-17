import sys,copy
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]
MAX = 0
for i in range(n):
    MAX = max(MAX,max(graph[i]))

def bfs(h):
    temp = copy.deepcopy(graph)
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if temp[i][j] <= h :
                temp[i][j] = 0

    def island(i,j,a):
        q = deque()
        q.append((i,j))
        while q:
            i,j = q.popleft()
            for di,dj in point:
                ni,nj = i+di,j+dj;
                if 0<=ni<n and 0<=nj<n and temp[ni][nj]!= 0 and visited[ni][nj] == 0:
                    visited[ni][nj] = 1
                    q.append((ni,nj))
                    temp[ni][nj] = a
    a = 0
    for i in range(n):
        for j in range(n):
            if temp[i][j] != 0 and visited[i][j] == 0 :
                a+=1
                visited[i][j] = 1
                island(i,j,a)

    return a

ans = 0
for i in range(MAX+1):
    k = bfs(i)
    if ans < k :
        ans = k
print(ans)
