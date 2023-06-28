import sys
from collections import deque
input = sys.stdin.readline

n,m,k,x = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited = [-1]*(n+1)

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)

q = deque()
q.append(x)
visited[x] = 0

while q :
    node = q.popleft()
    for v in graph[node] :
        if visited[v] == -1 :
            visited[v] = visited[node] + 1
            q.append(v)

ans = []
for i in range(1,n+1) :
    if visited[i] == k :
        ans.append(i)

if not ans :
    print(-1)
else :
    for v in ans :
        print(v)