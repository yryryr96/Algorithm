import sys
import heapq
input = sys.stdin.readline

n,m = map(int,input().split())
start = 1
INF = int(1e9)
graph = [[] for _ in range(n+1)]
distance = [INF for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q:
        dist, node = heapq.heappop(q)
        if distance[node] < dist :
            continue
        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost < distance[after[0]] :
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))

dijkstra(start)
print(distance[n])

