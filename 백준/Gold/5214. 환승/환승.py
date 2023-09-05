import sys
from collections import deque
input = sys.stdin.readline

n,k,m = map(int,input().split())
ht = [[]]
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)

q = deque()
q.append(1)
visited[1] = 1

for k in range(1,m+1):
    lst = list(map(int,input().split()))
    ht.append(lst)
    for v in lst :
        graph[v].append(k)

# print(ht)s

while q:
    node = q.popleft()
    # print(node)
    if node == n :
        print(visited[node])
        break

    for v in graph[node] :
        for i in ht[v] :
            if visited[i] == 0 :
                q.append(i)
                visited[i] = visited[node] + 1
else :
    print(-1)