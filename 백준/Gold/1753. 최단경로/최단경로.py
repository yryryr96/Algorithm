import sys
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int,input().split())  # 노드의 개수, 간선의 개수
start = int(input())    # 시작 노드
graph = [[] for _ in range(n+1)]    # 인접리스트
visited = [0] * (n+1)   # 방문 테이블
distance = [INF] * (n+1) # 거리 테이블

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1,n+1):
        if not visited[i] and distance[i] < min_value:
            min_value = distance[i]
            index = i
    return index

def dijkstra(start): # 단방향이고 모든 가중치가 0 이상일때만 사용 가능
    distance[start] = 0
    visited[start] = 1

    for i in graph[start]:
        if distance[i[0]] != 0:
            if i[1] < distance[i[0]]:
                distance[i[0]] = i[1]
        else:
            distance[i[0]] = i[1]  # i[0] : 연결 노드, i[1] : 가중치

    for _ in range(n-1):
        now = get_smallest_node()   # 방문하지 않고 바로 위에서 구한 연결된 노드들
        visited[now] = 1

        for after in graph[now] :
            cost = distance[now] + after[1]
            if cost < distance[after[0]] :
                distance[after[0]] = cost

dijkstra(start)

for i in range(1,n+1):
    if distance[i] == INF:
        print('INF')
    else :
        print(distance[i])
