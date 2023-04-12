import sys,heapq
input = sys.stdin.readline

def dijkstra(q,distance,limit):
    global INF
    while q:
        dist,node = heapq.heappop(q)
        if distance[node] < dist :
            continue
        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost > limit : continue
            if cost < distance[after[0]] :
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))

V,E = map(int,input().split())
graph = [[] for _ in range(V+1)]
INF = int(1e9)
for _ in range(E):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

M,x = map(int,input().split()) # 맥날 수, 맥날까지 거리 x이하
Mac = list(map(int,input().split())) # 맥날 노드번호
S,y = map(int,input().split()) # 스벅 수, 스벅까지 거리 y이하
Star = list(map(int,input().split())) #스벅 노드번호
total = Mac + Star
MIN = sys.maxsize

distancem = [INF]*(V+1)
distances = [INF]*(V+1)
mq,sq = [],[]
for i in Mac :
    distancem[i] = 0
    heapq.heappush(mq,(0,i))

for i in Star :
    distances[i] = 0
    heapq.heappush(sq,(0,i))

dijkstra(mq,distancem,x) #맥날
dijkstra(sq,distances,y) #스벅

for i in range(1,V+1):
    if i not in total :
        MIN = min(MIN,distances[i]+distancem[i])

if MIN >= int(1e9): # 조건 만족하는 집이 없을 때
    MIN = -1
print(MIN)