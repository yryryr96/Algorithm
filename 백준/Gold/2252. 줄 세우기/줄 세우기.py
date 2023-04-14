import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
Indegree = [0]*(n+1)

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    Indegree[b] += 1

q = deque()
for i in range(1,n+1):
    if Indegree[i] == 0 :
        q.append(i)

ans = []
while q : # 진입차수가 0인것만 q에 append
    now = q.popleft()
    ans.append(now)

    for v in graph[now] :
        Indegree[v] -= 1
        if Indegree[v] == 0 :
            q.append(v)

print(*ans)