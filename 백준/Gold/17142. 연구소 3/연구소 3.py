from collections import deque
from itertools import combinations
import sys
input = sys.stdin.readline

def bfs(p) :
    global ans
    q = deque()
    visited = [[-1]*n for _ in range(n)]
    for i in range(m):
        visited[p[i][0]][p[i][1]] = 0
        q.append(p[i])

    while q :
        i,j = q.popleft()
        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<n and visited[ni][nj] == -1 and graph[ni][nj] != 1:
                q.append((ni,nj))
                visited[ni][nj] = visited[i][j] + 1

    check = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 0:
                if visited[i][j] == -1 :
                    return False
                else :
                    check = max(check,visited[i][j])
    # for i in range(n):
    #     print(visited[i])
    # print('##########')
    ans = min(ans,check)
    return True


n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
viruses = []
ans = sys.maxsize
for i in range(n):
    for j in range(n):
        if graph[i][j] == 2 :
            viruses.append((i,j))


for p in combinations(viruses,m):
    bfs(p)

if ans == sys.maxsize :
    print(-1)
else :
    print(ans)