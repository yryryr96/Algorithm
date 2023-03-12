import sys
import heapq
input = sys.stdin.readline

n,m,x = map(int,input().split())
INF = int(1e9)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b,t = map(int,input().split())
    graph[a].append((b,t))
def dijkstra(start,end):
    distance = [INF for _ in range(n + 1)]
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q:
        dist,node = heapq.heappop(q)
        if dist > distance[node] :
            continue

        if node == end :
            return distance[end]

        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost < distance[after[0]]:
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))

ans = 0
for i in range(1,n+1):
    temp = dijkstra(i,x) + dijkstra(x,i)
    if ans < temp :
        ans = temp
print(ans)