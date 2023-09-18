import sys
from collections import deque
input = sys.stdin.readline

n,m,r = map(int,input().split())
graph = [[] for _ in range(n+1)]
item_cnt = [0] + list(map(int,input().split()))

for _ in range(r):
    a,b,d = map(int,input().split())
    graph[a].append((b,d))
    graph[b].append((a,d))

INF = sys.maxsize
ans = 0
def dijk(v) :
    global INF, m, ans

    q = deque()
    q.append((0,v))
    distance = [INF] * (n + 1)
    distance[v] = 0

    while q :
        dist, node = q.popleft()

        if dist > distance[node] : continue

        for k,d in graph[node] :
            nd = distance[node] + d
            if distance[k] > nd :
                q.append((nd,k))
                distance[k] = nd

    cnt = 0
    for i in range(1,n+1):
        if distance[i] <= m :
            cnt += item_cnt[i]

    ans = max(cnt, ans)

for i in range(1,n+1):
    dijk(i)

print(ans)