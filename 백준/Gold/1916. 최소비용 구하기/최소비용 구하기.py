import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())
INF = int(1e9)
graph = [[] for _ in range(n+1)]
distance = [INF for _ in range(n+1)]
for _ in range(m):
    a,b,c, = map(int,input().split())
    graph[a].append((b,c))

start, end = map(int,input().split())
def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0

    while q:
        dist, node = heapq.heappop(q)
        if dist > distance[node] :
            continue

        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost < distance[after[0]] :
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))

dijkstra(start)
print(distance[end])