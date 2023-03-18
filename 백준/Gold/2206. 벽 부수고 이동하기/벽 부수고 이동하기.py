import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [input().rstrip() for _ in range(n)]

def bfs():

    visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
    point = [[-1,0],[0,-1],[0,1],[1,0]]
    q = deque()
    q.append((0,0,0))
    visited[0][0][0] = 1

    while q :
        i,j,check = q.popleft()
        if i == n-1 and j == m-1 :
            return visited[i][j][check]

        for di,dj in point :
            ni,nj = i + di, j + dj

            if 0<=ni<n and 0<=nj<m :
                if graph[ni][nj] == '1' and check == 0 :
                    visited[ni][nj][1] = visited[i][j][0] + 1
                    q.append((ni,nj,1))
                elif graph[ni][nj] == '0' and visited[ni][nj][check] == 0 :
                    visited[ni][nj][check] = visited[i][j][check] + 1
                    q.append((ni,nj,check))


    return -1

print(bfs())