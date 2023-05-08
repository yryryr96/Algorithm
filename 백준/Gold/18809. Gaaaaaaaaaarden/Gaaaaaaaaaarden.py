import sys, copy
from itertools import combinations
from collections import deque
input = sys.stdin.readline

N,M,G,R = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
check = []
MAX = 0
for i in range(N) :
    for j in range(M) :
        if graph[i][j] == 2 :
            check.append((i,j))

def bfs(green,red) :
    global MAX
    temp = copy.deepcopy(graph)
    visited = [[-1]*M for _ in range(N)]
    q = deque()

    for r,c in green :
        temp[r][c] = 3
        visited[r][c] = 0
        q.append((r,c,'G'))

    for r,c in red :
        temp[r][c] = 4
        visited[r][c] = 0
        q.append((r,c,'R'))

    flower = 0
    while q:
        i,j,color = q.popleft()
        if temp[i][j] == 'F' : continue
        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<N and 0<=nj<M :
                if color == 'G' :
                    if visited[ni][nj] == -1 and (temp[ni][nj] == 1 or temp[ni][nj] == 2) :
                        q.append((ni,nj,'G'))
                        visited[ni][nj] = visited[i][j] + 1
                        temp[ni][nj] = 3

                else :
                    if visited[ni][nj] == -1 and (temp[ni][nj] == 1 or temp[ni][nj] == 2):
                        q.append((ni,nj,'R'))
                        visited[ni][nj] = visited[i][j] + 1
                        temp[ni][nj] = 4

                    elif (visited[ni][nj] == visited[i][j] + 1) and temp[ni][nj] == 3 :
                        flower += 1
                        temp[ni][nj] = 'F'

    # for i in range(N):
    #     print(*temp[i])
    # print("##############")
    # print(f'#{flower}')
    if MAX < flower :
        MAX = flower
    return

for i in combinations(check,R+G):
    for green in combinations(i,G) :
        red = []
        for k in i :
            if k not in green :
                red.append(k)
        bfs(green,red)
print(MAX)