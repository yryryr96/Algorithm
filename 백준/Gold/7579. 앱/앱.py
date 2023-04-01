import sys
input = sys.stdin.readline

n,m = map(int,input().split())
memory = list(map(int,input().split()))
charge = list(map(int,input().split()))
lst = [(0,0)]
for i in range(n):
    lst.append((memory[i],charge[i]))

graph = [[0]*(sum(charge)+1) for _ in range(n+1)]
ans = sys.maxsize
for i in range(1,n+1):
    M = lst[i][0]
    C = lst[i][1]
    for j in range(1,sum(charge)+1):
        if C > j :
            graph[i][j] = graph[i-1][j]
        else :
            graph[i][j] = max(graph[i-1][j], graph[i-1][j-C] + M )

        if graph[i][j] >= m :
            ans = min(ans,j)

print(ans)