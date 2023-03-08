import sys
from collections import deque

N,M = map(int,input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    B,A = map(int,input().split())
    graph[A].append(B)
def bfs(v):
    cnt = 1
    q = deque([v])
    visited = [0] * (N + 1)
    visited[v] = 1

    while q :
        now = q.popleft()
        for i in graph[now] :
            if visited[i] == 0 :
                visited[i] = 1
                cnt += 1
                q.append(i)
    return cnt
MAX = 0
ans = []
for i in range(1,N+1):
    cnt = bfs(i)
    if cnt > MAX :
        MAX = cnt
        ans.clear()
        ans.append(i)

    elif cnt == MAX :
        ans.append(i)

print(*ans)