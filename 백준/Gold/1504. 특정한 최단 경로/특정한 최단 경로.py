import sys
import heapq
input = sys.stdin.readline

n,m = map(int,input().split())
INF = int(1e9)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

v1,v2 = map(int,input().split())
temp = 1
def dijkstra(s,e):
    global temp
    q = []
    distance = [INF for _ in range(n + 1)]
    heapq.heappush(q,(0,s))
    distance[s] = 0

    while q:
        dist,node = heapq.heappop(q)
        if node == e :
            return distance[node]

        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost < distance[after[0]] :
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))
    temp = 0
    return 0

ans = min(dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,n), dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,n))

if temp == 1:
    print(ans)
else :
    print(-1)

