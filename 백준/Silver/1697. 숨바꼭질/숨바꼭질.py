from collections import deque
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

graph = [[] for _ in range(100001)]
visited = [0]*100001
N,K = map(int,input().split())
def bfs(v,K):

    visited[v] = 1
    q = deque()
    q.append(v)

    while q:

        now = q.popleft()
        if now == K:
            return visited[now] - 1

        for after in [now+1,now-1,now*2] :
            if 0<= after <= 100000 and visited[after] == 0 :
                q.append(after)
                visited[after] = visited[now] + 1

print(bfs(N,K))
