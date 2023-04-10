import sys
input = sys.stdin.readline

n,k = map(int,input().split())
visited = [[0]*(n+1) for _ in range(n+1)]

for _ in range(k):
    a,b = map(int,input().split())
    visited[a][b] = 1

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1) :
            if i==j : continue
            if visited[i][j] or (visited[i][k] and visited[k][j]) :
                visited[i][j] = 1

s = int(input())
for _ in range(s):
    a,b = map(int,input().split())
    if visited[a][b] :
        print(-1)
    elif visited[b][a] :
        print(1)
    else:
        print(0)
