import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]
duck = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L' :
            duck.append((i,j))

def melting(q):
    global iceq
    n_iceq = deque()

    for i,j in q :
        graph[i][j] = '.'

    while q:
        i,j = q.popleft()
        for di,dj in point :
            ni,nj = i+di,j+dj
            if 0<=ni<n and 0<=nj<m and ice_visited[ni][nj] == -1 :
                if graph[ni][nj] == 'X' :
                    ice_visited[ni][nj] = 1
                    n_iceq.append((ni,nj))
                else:
                    ice_visited[ni][nj] = 1
                    q.append((ni,nj))
    iceq = n_iceq

def check(q):
    global duckq
    n_duckq = deque()

    while q:
        i,j = q.popleft()
        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m and duck_visited[ni][nj] == -1 :
                if graph[ni][nj] == '.' :
                    q.append((ni,nj))
                    duck_visited[ni][nj] = 1
                elif graph[ni][nj] == 'X' :
                    n_duckq.append((ni,nj))
                    duck_visited[ni][nj] = 1
                else :
                    return True
    duckq = n_duckq
    return False

duck_visited = [[-1]*m for _ in range(n)]
ice_visited = [[-1]*m for _ in range(n)]
duckq = deque()
duckq.append((duck[0][0],duck[0][1]))
duck_visited[duck[0][0]][duck[0][1]] = 1
iceq = deque()
q = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] != 'X' and ice_visited[i][j] == -1 :
           q.append((i,j))

while q :
    i,j = q.popleft()
    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<n and 0<=nj<m and ice_visited[ni][nj] == -1 :
            if graph[ni][nj] == 'X' :
                ice_visited[ni][nj] = 1
                iceq.append((ni,nj))
            else :
                q.append((ni,nj))
                ice_visited[ni][nj] = 1

ans = 0
while True :
    ans += 1
    melting(iceq)
    if check(duckq):
        print(ans)
        break
