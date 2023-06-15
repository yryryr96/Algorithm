import sys, heapq
from collections import deque
input = sys.stdin.readline

n,m,k = map(int,input().split())
A = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]

graph= [[deque() for _ in range(n)] for _ in range(n)]
visited = [[5]*n for _ in range(n)]

for _ in range(m):
    x,y,z = map(int,input().split())
    # heapq.heappush(graph[x-1][y-1],z)
    graph[x-1][y-1].append(z)

def SpringSummer():
    visited_die = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] :
                tree = []
                k = len(graph[i][j])
                # print(i,j,k,graph[i][j])
                for _ in range(k) :
                    a = graph[i][j].popleft()
                    # print(a)
                    if a > visited[i][j] :
                        visited_die[i][j] += a//2
                    else :
                        tree.append(a+1)
                        visited[i][j] -= a
                for l in tree :
                    graph[i][j].append(l)

    for i in range(n):
        for j in range(n):
            visited[i][j] += visited_die[i][j]

    return

def fall():
    for i in range(n):
        for j in range(n):
            for k in range(len(graph[i][j])) :
                if graph[i][j][k] % 5 == 0 :
                    # print(graph[i][j][k])
                    for di,dj in point :
                        ni,nj = i+di, j+dj
                        if 0<=ni<n and 0<=nj<n :
                            graph[ni][nj].appendleft(1)

    return

def winter():
    for i in range(n):
        for j in range(n):
            visited[i][j] += A[i][j]
    return

for l in range(k) :
    SpringSummer()
    fall()
    winter()

ans = 0
for i in range(n):
    for j in range(n):
        ans += len(graph[i][j])
print(ans)