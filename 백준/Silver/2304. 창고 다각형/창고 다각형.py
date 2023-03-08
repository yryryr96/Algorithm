import sys
input = sys.stdin.readline

graph = [[0 for _ in range(1001)] for _ in range(1001)]
N = int(input())
for _ in range(N):
    a,b = map(int,input().split())
    cnt = 1
    for j in range(b):
        graph[a][j] = cnt
        cnt += 1
MAX = 0
S_index = 0
M_index = 0
E_index = 0
ans = 0

for i in range(len(graph)):
    if graph[i][0] == 1:
        if S_index == 0:
            S_index = i
        else :
            E_index = i
    if MAX < max(graph[i]) :
        MAX = max(graph[i])
        M_index = i
MAX = 0
for i in range(M_index+1):
    if MAX < max(graph[i]):
        MAX = max(graph[i])
    ans += MAX

MAX2 = 0
for i in range(E_index,M_index,-1):
    if MAX2 < max(graph[i]) :
        MAX2 = max(graph[i])
    ans += MAX2
print(ans)

