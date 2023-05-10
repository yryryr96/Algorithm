import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[0]*(m+1) for _ in range(n+1)]
ans = 1

def dfs(i,j):
    global ans
    if j == m+1 :
        i += 1
        j = 1

    if i == n+1 :
       return 0

    if graph[i][j-1] == 0 or graph[i-1][j] == 0 or graph[i-1][j-1] == 0 :
        graph[i][j] = 1
        ans += 1
        dfs(i,j+1)
        graph[i][j] = 0

    dfs(i,j+1)
    return ans

dfs(1,1)
print(ans)