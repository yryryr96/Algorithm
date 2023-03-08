import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
cnt = 1
def dfs(s):
    global cnt
    visited[s] = cnt
    for i in graph[s] :
        if visited[i] == 0 :
            cnt += 1
            dfs(i)

N, M, R = map(int,input().split())
visited = [0]*(N+1)
graph = [[] for _ in range(N+1)]
st = []

for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for x in range(1,N+1):
    graph[x] = sorted(graph[x],reverse=True)

dfs(R)
for i in range(1,N+1):
    print(visited[i])


