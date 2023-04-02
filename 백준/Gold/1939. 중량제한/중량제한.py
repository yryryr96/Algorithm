import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]

def bfs(s,e,w):
    q = deque()
    visited = [0]*(n+1)
    visited[s] = 1
    q.append(s)
    while q :
        now = q.popleft()
        if now == e :
            return True

        for i in graph[now] :
            if not visited[i[0]] and i[1] >= w :
                visited[i[0]] = 1
                q.append(i[0])

    return False

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

s,e = map(int,input().split())
start,end = 1,sys.maxsize

while start <= end :
    mid = (start+end)//2
    if bfs(s,e,mid) :
        ans = mid
        start = mid + 1
    else :
        end = mid - 1

print(ans)