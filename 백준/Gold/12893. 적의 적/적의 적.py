import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline


n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0]*(n+1)
def dfs(v,group):
    visited[v] = group
    for i in graph[v] :
        if visited[i] == 0 :
            result = dfs(i,-group)
            if not result :
                return False

        elif visited[i] == group :
            return False
    return True

for i in range(1,n+1):
    if visited[i] == 0 :
        if not dfs(i,1):
            print(0)
            break
else :
    print(1)
