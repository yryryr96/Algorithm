N,M = map(int,input().split())
graph = [[]*(N+1) for _ in range(N+1)]
visited = [0]*(N+1)

for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    visited[v] = 1
    for i in graph[v] :
        if visited[i] == 0 :
            dfs(i)

ans = 0
for i in range(1,N+1):
    if visited[i] == 0 :
        dfs(i)
        ans += 1

print(ans)
