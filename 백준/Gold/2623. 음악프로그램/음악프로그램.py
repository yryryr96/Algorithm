import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
Indegree = [0]*(n+1)

for _ in range(m):
    lst = list(map(int,input().split()))
    k = lst[0]
    lst = lst[1:]
    for i in range(1,k):
        if lst[i] not in graph[lst[i-1]] :
            graph[lst[i-1]].append(lst[i])
            Indegree[lst[i]] += 1

q = deque()
for i in range(1,n+1):
    if Indegree[i] == 0 :
        q.append(i)

ans = []
while q : # 진입차수가 0인것만 q에 append
    now = q.popleft()
    ans.append(now)

    for v in graph[now] :
        Indegree[v] -= 1
        if Indegree[v] == 0 :
            q.append(v)

if len(ans) == n :
    for i in range(n):
        print(ans[i])
else:
    print(0)