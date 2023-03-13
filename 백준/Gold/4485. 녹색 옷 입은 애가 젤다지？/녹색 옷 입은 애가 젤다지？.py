import sys
import heapq
input = sys.stdin.readline
tc = 1
while True:

    n = int(input())
    if n == 0 :
        break

    INF = int(1e9)
    graph = [list(map(int,input().split())) for _ in range(n)]
    distance = [[INF]*(n) for _ in range(n)]
    def dijkstra():
        q = []
        point = [[0,1],[1,0],[-1,0],[0,-1]]
        heapq.heappush(q,(0,(0,0)))
        distance[0][0] = graph[0][0]
        while q:
            dist, node = heapq.heappop(q)

            if node == (n-1,n-1) :
                print(f'Problem {tc}: {distance[n-1][n-1]}')
                return

            if distance[node[0]][node[1]] < dist :
                continue

            for di,dj in point :
                ni,nj = node[0] + di, node[1] + dj
                if 0<=ni<n and 0<=nj<n :
                    cost = distance[node[0]][node[1]] + graph[ni][nj]

                    if cost < distance[ni][nj]:
                        distance[ni][nj] = cost
                        heapq.heappush(q,(cost,(ni,nj)))

    dijkstra()
    tc += 1

