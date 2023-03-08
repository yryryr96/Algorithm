from collections import deque
import sys
input = sys.stdin.readline

graph = [list(map(str,input().rstrip())) for _ in range(12)]
point = [[0,0],[0,1],[1,0],[-1,0],[0,-1]]

def bfs(i,j):
    global cnt,check
    q = deque()
    visited = [[0 for _ in range(6)] for _ in range(12)]
    q.append((i,j))
    visited[i][j] = 0
    lst = []
    while q:
        now = q.popleft()
        for di,dj in point :
            ni, nj = now[0] + di, now[1] + dj
            if 0<=ni<12 and 0<=nj<6 and visited[ni][nj] == 0 :
                if graph[ni][nj] == graph[now[0]][now[1]] :
                    q.append((ni,nj))
                    visited[ni][nj] = 1
                    lst.append((ni,nj))
                    cnt += 1
    if cnt >= 4 :
        check += 1
        for k,n in lst:
            graph[k][n] = '.'

ans = 0
while True :
    cnt = check = 0
    ans += 1
    for j in range(6):
        for i in range(11,-1,-1):
            cnt = 0
            if graph[i][j].isalpha():
                bfs(i,j)

    if check == 0 :
        break

    # 정렬
    for j in range(6):
        for i in range(11, -1, -1):
            Idx = i
            if graph[i][j].isalpha():
                for k in range(i + 1, 12):
                    if graph[k][j] == '.':
                        Idx = k
                graph[i][j], graph[Idx][j] = graph[Idx][j], graph[i][j]


print(ans-1)