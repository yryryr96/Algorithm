import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
graph = [[] for _ in range(n+1)]
dp = [[0,1] for _ in range(n+1)]

for _ in range(n-1):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0]*(n+1)

def dfs(start):
    visited[start] = 1

    for child in graph[start] :
        if not visited[child] :
            dfs(child)

            dp[start][0] += dp[child][1]

            dp[start][1] += min(dp[child][0],dp[child][1])

dfs(1)

print(min(dp[1][0],dp[1][1]))
