import sys
from collections import deque
input = sys.stdin.readline

def bfs(i,j) :
    visited = [[-1]*(m+2) for _ in range(n+2)]
    q = deque()
    q.append((i,j))
    visited[i][j] = 0
    while q:
        now = q.popleft()
        for di,dj in point :
            ni,nj = now[0] + di, now[1] + dj
            if 0<=ni<n+2 and 0<=nj<m+2 and visited[ni][nj] == -1 :
                if graph[ni][nj] == '.' or graph[ni][nj] == '$':
                    visited[ni][nj] = visited[now[0]][now[1]]
                    q.appendleft((ni,nj))

                elif graph[ni][nj] == '#' :
                    visited[ni][nj] = visited[now[0]][now[1]] + 1
                    q.append((ni,nj))

    return visited

T = int(input())
for tc in range(T):
    n,m = map(int,input().split())
    graph = [['.']*(m+2)] + [['.'] + list(input().rstrip()) + ['.'] for _ in range(n)] + [['.']*(m+2)]
    point = [[0,1],[1,0],[-1,0],[0,-1]]
    criminal = []
    for i in range(n+2):
        for j in range(m+2):
            if graph[i][j] == '$' :
                criminal.append((i,j))

    v1 = bfs(criminal[0][0],criminal[0][1])
    v2 = bfs(criminal[1][0],criminal[1][1])
    v3 = bfs(0,0)

    MIN = sys.maxsize
    for i in range(1,n+1):
        for j in range(1,m+1):
            if v1[i][j] != -1 and v2[i][j] != -1 and v3[i][j] != -1 :
                temp = v1[i][j] + v2[i][j] + v3[i][j]
                if graph[i][j] == '#' :
                    temp -= 2
                MIN = min(temp,MIN)
    print(MIN)