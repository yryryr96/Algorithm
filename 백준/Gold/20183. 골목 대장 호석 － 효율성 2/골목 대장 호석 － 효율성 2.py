import sys, heapq
input = sys.stdin.readline

N, M, A, B, C = map(int,input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b,d = map(int,input().split())
    graph[a].append((b,d))
    graph[b].append((a,d))

def dijkstra(A,B) :
    global C

    q = []
    heapq.heappush(q, (0,0,A)) # 최대, 총, 현재 노드
    distance = [1e9] * (N+1)
    distance[A] = 0

    ans = sys.maxsize
    while q :
        md, d, node = heapq.heappop(q)

        if node == B :
            ans = min(md,ans)

        if distance[node] < d : continue

        for v,dist in graph[node] :
            cost = distance[node] + dist
            k = max(md,dist)
            if k < distance[v] and cost <= C:
                distance[v] = k
                heapq.heappush(q,(k,cost,v))

    return ans

k = dijkstra(A,B)
ans = k if k != sys.maxsize else -1
print(ans)

