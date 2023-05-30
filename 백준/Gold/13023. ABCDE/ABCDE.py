import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[] for _ in range(n)]
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)



def dfs(v,cnt):
    if cnt == 5 :
        print(1)
        exit()

    for i in graph[v] :
        if visited[i] == 0 :
            visited[i] = 1
            dfs(i,cnt+1)
            visited[i] = 0

visited = [0]*n
for i in range(n):
    visited[i] = 1
    dfs(i,1)
    visited[i] = 0
print(0)