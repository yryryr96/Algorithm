import sys
import heapq
input = sys.stdin.readline

n,k = map(int,input().split())
q = []
heapq.heappush(q, (0, n))
INF = int(1e9)
graph = [[] for _ in range(100001)]
distance = [INF for _ in range(100001)]
distance[n] = 0

while q:
    dist, node = heapq.heappop(q)
    if distance[node] < dist:
        continue

    if node == k:
        print(distance[node])
        break

    for b in [node - 1, node + 1]:
        if 0<=b<100001:
            graph[node].append((b, 1))

    if node*2 < 100001:
        graph[node].append((node * 2, 0))

    for after in graph[node]:
        cost = distance[node] + after[1]
        if cost < distance[after[0]]:
            distance[after[0]] = cost
            heapq.heappush(q, (cost, after[0]))


