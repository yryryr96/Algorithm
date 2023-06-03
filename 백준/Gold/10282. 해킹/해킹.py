import sys,heapq
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n,d,c = map(int,input().split())
    graph = [[] for _ in range(n+1)]
    times = [1e9]*(n+1)
    times[c] = 0

    for _ in range(d):
        a,b,s = map(int,input().split())
        graph[b].append((a,s))

    q = []
    heapq.heappush(q,(0,c))

    while q:
        t, com = heapq.heappop(q)
        if t > times[com] : continue

        for v in graph[com] :
            time = v[1] + t
            if time < times[v[0]] :
                times[v[0]] = time
                heapq.heappush(q,(time,v[0]))

    cnt_com = 0
    total_time = 0
    for i in times :
        if i != 1e9 :
            cnt_com += 1
            total_time = max(total_time,i)
    print(cnt_com, total_time)