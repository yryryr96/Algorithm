import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
point = [[1,0],[0,1],[-1,0],[0,-1]]

def bfs() :

    q = deque()
    visited = [[0]*m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if graph[i][j] == '@' :
                si,sj = i,j
                visited[i][j] = 1

            elif graph[i][j] == '*' :
                q.append((i,j,0,0))
                visited[i][j] = -1

    q.appendleft((si,sj,0,1))

    while q :
        i,j,cnt, state = q.popleft()
        # print(i,j)
        if (i == n-1 or i == 0 or j == m-1 or j == 0) and visited[i][j] != -1 :
            return cnt + 1

        for di,dj in point :
            ni,nj = i+di, j+dj
            if not (0<=ni<n and 0<=nj<m) : continue
            if not state :
                if visited[ni][nj] != -1 and graph[ni][nj] != '#' :
                    q.append((ni,nj,cnt+1,0))
                    visited[ni][nj] = -1
            else :
                if visited[ni][nj] == 0 and graph[ni][nj] != '#' :
                    q.append((ni,nj,cnt+1,1))
                    visited[ni][nj] = visited[i][j] + 1

    return False

for _ in range(T):
    m, n = map(int,input().split())
    graph = [input().rstrip() for _ in range(n)]

    ans = bfs()
    if not ans :
        print("IMPOSSIBLE")
    else :
        print(ans)

