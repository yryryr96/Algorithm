import sys,heapq
input = sys.stdin.readline

V,M = map(int,input().split())
graph = [[] for _ in range(V+1)]
for _ in range(M):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

J,S = map(int,input().split())

INF = sys.maxsize
distance_j = [INF] * (V+1)
distance_s = [INF] * (V+1)

def dijkstra(v,distance) :
    q = []
    # print(distance)
    distance[v] = 0
    heapq.heappush(q,(0,v))

    while q :
        dist,node = heapq.heappop(q)

        if distance[node] < dist : continue

        for v,d in graph[node] :
            if distance[v] > distance[node] + d :
                distance[v] = distance[node] + d
                heapq.heappush(q,(distance[v],v))

    return distance


a = dijkstra(J,distance_j)
b = dijkstra(S,distance_s)
ans_list = []
MIN = sys.maxsize
# print(a)
# print(b)
#거리, 지헌이와의 거리, 번호 순서
for i in range(1,V+1) :
    if i == J or i == S : continue
    MIN = min(a[i]+b[i],MIN)
    ans_list.append((a[i]+b[i],a[i],i))

ans_list.sort()
# print(MIN)
# print(ans_list)
ans = sys.maxsize
for i in range(len(ans_list)) :
    if ans_list[i][0] == MIN and ( a[ans_list[i][2]] <= b[ans_list[i][2]]) :
        print(ans_list[i][2])
        break
else :
    print(-1)