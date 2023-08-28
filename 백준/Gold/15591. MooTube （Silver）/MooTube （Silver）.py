import sys
from collections import deque
input = sys.stdin.readline

N,Q = map(int,input().split())
graph = [[] for _ in range(N+1)]
for _ in range(N-1):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

for _ in range(Q) :

    K,V = map(int,input().split())
    distance = [1e9]*(N+1)
    visited = [0]*(N+1)
    q = deque()
    q.append(V)
    # print(q)
    while q:
        node = q.popleft()
        for v,d in graph[node] :
            if v == V : continue
            # print(v,node,distance[v],min(d,distance[node]))
            if visited[v] == 0 and min(d,distance[node]) < distance[v] :
                distance[v] = min(d,distance[node])
                visited[v] = 1
                q.append(v)

    ans = 0
    # print(distance)
    for i in range(1,N+1):
        if distance[i] >= K and distance[i] != 1e9:
            ans += 1

    print(ans)
