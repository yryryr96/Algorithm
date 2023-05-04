import sys
import heapq

INF = sys.maxsize // 2

n, m, s, e = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(101)]
visit = [False] * 101
dist = [[INF] * 101 for _ in range(10001)]
pq = []
max_cost = 0
for _ in range(m):
    p, r, c, t = map(int, sys.stdin.readline().split())
    graph[p].append((r, t, c))
    graph[r].append((p, t, c))
    max_cost = max(max_cost, n*c)


def dijk():
    for i in range(max_cost + 1):
        for j in range(1, n + 1):
            dist[i][j] = INF

    dist[0][s] = 0
    heapq.heappush(pq, (0, 0, s))
    while pq:
        cur_dist, cur_cost, cur = heapq.heappop(pq)

        if cur_dist <= dist[cur_cost][cur]:
            for nxt, time, cost in graph[cur]:
                nxt_cost = cur_cost + cost
                nxt_dist = cur_dist + time
                if nxt_cost <= max_cost and nxt_dist < dist[nxt_cost][nxt]:
                    dist[nxt_cost][nxt] = nxt_dist
                    heapq.heappush(pq, (nxt_dist, nxt_cost, nxt))

dijk()
ans = 0
min_dist = max_cost
for i in range(max_cost + 1):
    if dist[i][e] != INF and dist[i][e] < min_dist:
        ans += 1
        min_dist = dist[i][e]

print(ans)