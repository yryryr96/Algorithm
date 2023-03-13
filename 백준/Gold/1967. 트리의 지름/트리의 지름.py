import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
# 우선 1번 노드에서 제일 먼 노드를 찾는다 > 그 노드에서 제일 먼 노드를 찾는다

def dfs(x,y): # 시작 노드, 가중치
    for a,b in graph[x] : # a,b = 연결된 노드, 가중치
        if visited[a] == -1 :
            visited[a] = y+b
            dfs(a,y+b)

n = int(input())
graph = [[] for _ in range(n+1)]
visited = [-1]*(n+1)

for _ in range(n-1):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

visited[1] = 0 # 시작노드 1 가중치 0
dfs(1,0)
start = visited.index(max(visited)) # 1번 노드에서 가장 먼 노드
visited = [-1]*(n+1)
visited[start] = 0
dfs(start,0) # start 에서 가장 먼 노드
print(max(visited))


