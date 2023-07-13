import sys
from collections import deque
input = sys.stdin.readline

n,m,k = map(int,input().split())
graph = [input().rstrip() for _ in range(n)]
visited = [[[0]*m for _ in range(n)] for _ in range(k+2)]
point = [[0,1],[1,0],[0,-1],[-1,0]]

def bfs() :
    visited[0][0][0] = 1
    q = deque()
    q.append((0,0,0))

    while q :
        cnt,i,j = q.popleft()

        if cnt > k :
            continue

        if i == n-1 and j == m-1 :
            return visited[cnt][i][j]

        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m :
                if visited[cnt][ni][nj] == 0 and graph[ni][nj] == '0' :
                    q.append((cnt,ni,nj))
                    visited[cnt][ni][nj] = visited[cnt][i][j] + 1
                elif graph[ni][nj] == '1' and visited[cnt+1][ni][nj] == 0:
                    q.append((cnt+1,ni,nj))
                    visited[cnt+1][ni][nj] = visited[cnt][i][j] + 1
    return -1

print(bfs())