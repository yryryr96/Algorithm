import sys
input = sys.stdin.readline

n = int(input())
visited = [0 for _ in range(n+1)]
graph = [[] for _ in range(n+1)]

for i in range(1,n+1):
    lst = list(map(int,input().split()))
    l = lst[0]
    for j in range(1,l+1):
        if lst[j] not in graph[i] :
            graph[i].append(lst[j])
        if i not in graph[lst[j]] :
            graph[lst[j]].append(i)

def dfs(v,t):
    visited[v] = t
    for i in range(1,n+1):
        if i in graph[v] and visited[i] == 0:
            dfs(i,-t)


for i in range(1,n+1):
    if visited[i] == 0 :
        dfs(i,1)

print(visited.count(1))
for i in range(1,n+1):
    if visited[i] == 1:
        print(i,end=' ')
print()
print(visited.count(-1))
for i in range(1,n+1):
    if visited[i] == -1 :
        print(i,end=' ')