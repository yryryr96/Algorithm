import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
def check_island():
    k = 0
    q = deque()
    visited = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if graph[i][j] and visited[i][j] == 0:
                k+=1
                if k == 2 :
                    return k
                visited[i][j] = k
                q.append((i,j))
                while q :
                    r,c =q.popleft()
                    for di,dj in point :
                        ni,nj = r+di, c+dj
                        if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 and graph[ni][nj]:
                            q.append((ni,nj))
                            visited[ni][nj] = k

    return k

def bfs():
    q = []
    for i in range(n):
        for j in range(m):
            cnt = 0
            if graph[i][j] :
                for di,dj in point :
                    ni,nj = i+di, j+dj
                    if graph[ni][nj] == 0 :
                        cnt += 1
            q.append((i,j,cnt))

    while q :
        i,j,num = q.pop()
        graph[i][j] -= num
        if graph[i][j] < 0 :
            graph[i][j] = 0

    return

ans = 0
while True :
    ans += 1
    bfs()
    a = check_island()
    if a == 2 :
        print(ans)
        break
    if a == 0 :
        print(0)
        break

