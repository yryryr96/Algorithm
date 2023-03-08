import sys
from collections import deque
input = sys.stdin.readline
cnt = 1
def bfs(v):
    global cnt
    q = deque()
    visited[v] = cnt
    q.append(v)
    while q:
        x = q.popleft()
        for i in graph[x]:
            if not visited[i] :
                cnt += 1
                visited[i] = cnt
                q.append(i)

N,M,R = map(int,input().split())
visited = [0]*(N+1)
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for x in range(N+1):
    graph[x].sort()

bfs(R)

for i in range(1,N+1):
    print(visited[i])