import sys,heapq
input = sys.stdin.readline

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
q = []

for i in range(n):
    for j in range(n):
        if len(q) < n :
            heapq.heappush(q,graph[i][j])
        else :
            if q[0] < graph[i][j] :
                heapq.heappop(q)
                heapq.heappush(q,graph[i][j])

ans = q[0]
print(ans)
