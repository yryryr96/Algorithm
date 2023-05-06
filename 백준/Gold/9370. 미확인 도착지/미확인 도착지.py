import sys, heapq
input = sys.stdin.readline

def dijk(s,distance):
    q = []
    heapq.heappush(q,(0,s))
    distance[s] = 0
    while q :
        dist, node = heapq.heappop(q)

        if dist > distance[node] :
            continue

        for after in graph[node] :
            cost = distance[node] + after[1]
            if cost < distance[after[0]] :
                distance[after[0]] = cost
                heapq.heappush(q,(cost,after[0]))

T = int(input())
for _ in range(T) :
    n,m,t = map(int,input().split())
    s,g,h = map(int,input().split())
    graph = [[] for _ in range(n+1)]
    D = 0
    for _ in range(m): # 간선
        a,b,d = map(int,input().split())
        graph[a].append((b,d))
        graph[b].append((a,d))
        if (a == g and b == h) or (b == g and a == h) :
            D = d

    check = []
    for _ in range(t):
        p = int(input())
        check.append(p)

    min_dist = sys.maxsize

    distance_s = [sys.maxsize] * (n + 1)
    dijk(s,distance_s)
    distance_g = [sys.maxsize] * (n + 1)
    dijk(g,distance_g)
    distance_h = [sys.maxsize] * (n + 1)
    dijk(h,distance_h)

    ans = []
    for i in check :
        if distance_s[g] + D + distance_h[i] <= distance_s[i] or distance_s[h]+D+distance_g[i] <= distance_s[i] :
            ans.append(i)
    
    ans.sort()
    print(*ans)
