import sys
from collections import deque
input = sys.stdin.readline

def island(i,j,v):
    q = deque()
    q.append((i,j))
    visited[i][j] = 1

    while q:
        now = q.popleft()
        for di,dj in point :
            ni,nj = now[0]+di, now[1]+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 and graph[ni][nj] != 0:
                visited[ni][nj] = 1
                graph[ni][nj] = v
                q.append((ni,nj))

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    parent[max(a,b)] = min(a,b)


def dist(i,j,v):
    global edges
    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<n and 0<=nj<m and graph[ni][nj] == 0 :
            distance = 0
            while 0<=ni<n and 0<=nj<m :
                if graph[ni][nj] != v and graph[ni][nj] != 0 :
                    if distance >= 2 :
                        edges.add((distance,v,graph[ni][nj]))
                    break

                if graph[ni][nj] == v :
                    break;

                distance += 1
                ni+=di
                nj+=dj
    return

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*(m) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]
k = 0

# 섬 나누기
for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and graph[i][j] == 1 :
            graph[i][j] = k+1
            island(i,j,k+1)
            k+=1

parent = list(range(0,k+1))
edges = set()
for i in range(n):
    for j in range(m):
        if graph[i][j] != 0 :
            dist(i,j,graph[i][j])

edges = list(edges)
edges.sort()
ans = 0
for c,a,b in edges:
    if find(a) != find(b) :
        union(a,b)
        ans += c

for i in range(1,k+1):
    find(i)

check = set(parent[1:])
if len(check) == 1:
    print(ans)
else:
    print(-1)

