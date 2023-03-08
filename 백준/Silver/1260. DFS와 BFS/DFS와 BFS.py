from collections import deque
import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = 1
    print(v, end = ' ')
    for i in range(1,n+1):
        if visited[i] == 0 and graph[v][i] == 1 :
            dfs(i)

def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = 1
    while q:
        v = q.popleft()
        print(v,end = ' ')
        for i in range(1,n+1):
            if visited[i] == 0 and graph[v][i] == 1:
                q.append(i)
                visited[i]=1

n,m,v = map(int,input().split())

graph = [[0 for _ in range(n+1)] for _ in range(n+1)]
visited = [0]*(n+1)

for _ in range(m):
    a,b = map(int,input().split())
    graph[a][b] = graph[b][a] = 1

dfs(v)
print()
visited = [0]*(n+1)
bfs(v)


