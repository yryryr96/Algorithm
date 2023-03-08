import sys
from collections import deque
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
T = int(input())
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]
visited = [0]*(N+1)
stack = [1]
for _ in range(T) :
    a,b = map(int,input().split())
    graph[a][b] = 1
    graph[b][a] = 1

while stack:

    now = stack.pop()
    visited[now] = 1

    for i in range(1,N+1):
        if visited[i] == 0 and graph[now][i] == 1 :
            stack.append(i)
cnt = 0

for i in range(2,len(visited)):
    if visited[i] == 1:
        cnt+=1
print(cnt)


