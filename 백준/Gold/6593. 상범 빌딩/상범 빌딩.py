import sys
from collections import deque
input = sys.stdin.readline


def bfs(h,r,c) :
    q = deque()
    q.append((h,r,c))
    visited[h][r][c] = 0

    while q :
        k,i,j = q.popleft()

        if (k,i,j) == e :
            print(f'Escaped in {visited[k][i][j]} minute(s).')
            return

        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<R and 0<=nj<C and visited[k][ni][nj] == -1 and (graph[k][ni][nj] == '.' or graph[k][ni][nj] == 'E') :
                q.append((k,ni,nj))
                visited[k][ni][nj] = visited[k][i][j] + 1

        for l in [1,-1] :
            nk = k + l
            if 0<=nk<L and visited[nk][i][j] == -1 and (graph[nk][i][j] == '.' or graph[nk][i][j] == 'E' ) :
                q.append((nk,i,j))
                visited[nk][i][j] = visited[k][i][j] + 1

    return print("Trapped!")

point = [[0,1],[1,0],[0,-1],[-1,0]]
while True :
    L,R,C = map(int,input().split())

    if L == 0 and R == 0 and C == 0 :
        break

    graph = [[] for _ in range(L)]
    for i in range(L) :
        lst = []
        while True:
            a = list(input().rstrip())
            if not a : break
            else : lst.append(a)
        graph[i] = lst

    visited = [[[-1]*C for _ in range(R)] for _ in range(L)]

    for i in range(L) :
        for j in range(R):
            for k in range(C):
                if graph[i][j][k] == "S" : s = (i,j,k)
                elif graph[i][j][k] == "E" : e = (i,j,k)
    bfs(*s)