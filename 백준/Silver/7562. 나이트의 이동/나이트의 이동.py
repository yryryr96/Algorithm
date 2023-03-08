from collections import deque
import sys
sys.setrecursionlimit(10**6)

point = [[-1,-2],[-2,-1],[-2,1],[-1,2],[1,2],[2,1],[2,-1],[1,-2]]

def bfs(i,j):
    visited[i][j] = 1
    q = deque()
    q.append((i,j))

    while q:
        now = q.popleft()

        for di,dj in point:
            ni, nj = now[0]+di, now[1]+dj
            if 0<=ni<N and 0<=nj<N and visited[ni][nj] == 0 :
                if graph[ni][nj] == 0 :
                    graph[ni][nj] = 2
                    q.append((ni,nj))
                    visited[ni][nj] = visited[now[0]][now[1]] + 1
                elif graph[ni][nj] == 1:
                    return visited[now[0]][now[1]]
    return 0

T = int(input())
for tc in range(T):
    N = int(input())
    si,sj = map(int,input().split())
    ei,ej = map(int,input().split())
    graph = [[0 for _ in range(N)] for _ in range(N)]
    visited = [[0 for _ in range(N)] for _ in range(N)]
    graph[ei][ej] = 1

    print(bfs(si,sj))