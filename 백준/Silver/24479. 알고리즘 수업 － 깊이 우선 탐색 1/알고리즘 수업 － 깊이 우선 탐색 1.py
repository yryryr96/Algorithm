import sys
from collections import deque
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N,M,R = map(int,input().split())
adj = [[] for _ in range(N+1)]
visited = [0]*(N+1)
cnt = 1
def dfs(graph,v,visited):
    global cnt
    visited[v] = cnt
    for i in graph[v] :
        if visited[i] == 0 :
            cnt += 1
            dfs(graph,i,visited)
            
for _ in range(M):
    a,b = map(int,input().split())
    adj[a].append(b)
    adj[b].append(a)

for x in range(1, N+1):
    adj[x].sort()

dfs(adj,R,visited)

for i in range(1,N+1):
    print(visited[i])
