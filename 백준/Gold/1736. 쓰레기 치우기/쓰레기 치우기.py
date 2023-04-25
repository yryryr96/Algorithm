import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

def dfs(r,c) :

    for i in range(r,n):
        for j in range(c,m) :
            if graph[i][j] == 1:
                graph[i][j] = 0
                dfs(i,j)
                return
    return

k = 0
while True :
    k+=1
    SUM = 0
    dfs(0,0)
    for i in range(n):
        SUM += sum(graph[i])
    if SUM == 0 :
        print(k)
        break


