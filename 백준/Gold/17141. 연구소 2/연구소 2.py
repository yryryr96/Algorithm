import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]

possible = 0

def check(graph,visited) :

    global possible

    for i in range(n):
        for j in range(n):
            if graph[i][j] != 1 and visited[i][j] == -1 :
                return False

    possible = 1
    return True

ans = sys.maxsize

def bfs(viruses) :
    global ans

    q = deque()
    visited = [[-1]*n for _ in range(n)]
    for i,j in viruses :
        visited[i][j] = 0
        q.append((i,j))

    cnt = 0
    while q :
        i,j = q.popleft()
        cnt = visited[i][j]
        for di,dj in point :
            ni,nj = i+di, j+dj
            if not(0<=ni<n and 0<=nj<n) : continue
            if graph[ni][nj] != 1 and visited[ni][nj] == -1 :
                q.append((ni,nj))
                visited[ni][nj] = visited[i][j] + 1

    if check(graph,visited) :
        # for i in range(n):
        #     print(*visited[i])
        # print("#########")
        ans = min(ans,cnt)

    return


def solution() :
    global ans

    comb = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 2 :
                comb.append((i,j))

    for p in combinations(comb,m) :
        bfs(p)

    if ans == sys.maxsize : print(-1)
    else : print(ans)

    return

solution()