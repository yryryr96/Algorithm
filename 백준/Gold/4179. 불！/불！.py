import sys
from collections import deque
input = sys.stdin.readline

r,c = map(int,input().split())
graph = [input().rstrip() for _ in range(r)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
def bfs(graph) :
    q = deque()
    visited = [[[0]*c for _ in range(r)] for _ in range(2)]
    for i in range(r):
        for j in range(c):
            if graph[i][j] == 'J' :
                a,b = i,j
            elif graph[i][j] == 'F' :
                q.append((i,j,'f'))
                visited[0][i][j] = -1
    q.append((a,b,'j'))
    while q :
        i,j,who = q.popleft()
        if who == 'j' and ((i == 0 or i == r - 1) or (j == 0 or j == c - 1)):
            print(visited[1][i][j] + 1)
            return

        if i!= a and j!=b and who == 'j' and visited[0][i][j] == -1 :
            continue

        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<r and 0<=nj<c :
                if who == 'j' and graph[ni][nj] == '.' and visited[0][ni][nj] == 0 :
                    q.append((ni,nj,'j'))
                    visited[0][ni][nj] = 1
                    visited[1][ni][nj] = visited[1][i][j] + 1

                elif who == 'f' and (graph[ni][nj] == '.' or graph[ni][nj] == 'J') and visited[0][ni][nj] >= 0 :
                    q.append((ni,nj,'f'))
                    visited[0][ni][nj] = -1

    print("IMPOSSIBLE")
    return

bfs(graph)
