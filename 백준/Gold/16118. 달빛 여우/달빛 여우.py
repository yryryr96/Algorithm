import sys,heapq
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c*2))
    graph[b].append((a,c*2))


def dijkstra(distance):
    q = []
    heapq.heappush(q,(0,1))
    distance[1] = 0
    while q:
        dist,node = heapq.heappop(q)
        if dist > distance[node]:
            continue
        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost < distance[after[0]] :
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))

def dijk(distance) :
    q = []
    heapq.heappush(q,(0,1,0))
    distance[1][1] = 0
    while q:
        dist, node, state = heapq.heappop(q)
        if not state and dist > distance[1][node]:
            continue
        elif state and dist > distance[0][node] :
            continue

        for after in graph[node]:
            if state == 0 : # 걷기
                cost = dist + after[1]//2
                if cost < distance[0][after[0]] :
                    distance[0][after[0]] = cost
                    heapq.heappush(q,(cost,after[0],1))
            else :
                cost = dist + after[1]*2
                if cost < distance[1][after[0]] :
                    distance[1][after[0]] = cost
                    heapq.heappush(q,(cost,after[0],0))

distance_fox = [sys.maxsize]*(n+1)
dijkstra(distance_fox)
distance_wolf = [[sys.maxsize]*(n+1) for _ in range(2)]
dijk(distance_wolf)

cnt = 0
for i in range(1,n+1):
    if distance_fox[i] < min(distance_wolf[0][i],distance_wolf[1][i]):
        cnt += 1
print(cnt)
