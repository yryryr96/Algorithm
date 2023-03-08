import sys
input = sys.stdin.readline

N,M = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
s_graph = [[0 for _ in range(N+1)] for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,N+1):
        s_graph[i][j] = graph[i-1][j-1] + s_graph[i-1][j] + s_graph[i][j-1] - s_graph[i-1][j-1]

for _ in range(M):
    y1,x1,y2,x2 = map(int,input().split())
    ans = s_graph[y2][x2] - s_graph[y2][x1-1] - s_graph[y1-1][x2] + s_graph[y1-1][x1-1]
    print(ans)