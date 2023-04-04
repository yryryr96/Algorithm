import sys,math
input = sys.stdin.readline

def dist(x1,y1,x2,y2):
    return math.sqrt(pow(x1-x2,2) + pow(y1-y2,2))

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    parent[max(a,b)] = min(a,b)

n,m = map(int,input().split())
parent = list(range(n+1))
graph = [0]

for _ in range(n):
    x,y = map(int,input().split())
    graph.append((x,y))

for _ in range(m) :
    a,b = map(int,input().split())
    union(a,b)

edges = []
for i in range(1,n):
    for j in range(i+1,n+1) :
        edges.append((dist(*graph[i],*graph[j]),i,j))
edges.sort()
ans = 0
for i in range(len(edges)) :
    distance,a,b = edges[i]
    if find(a) != find(b):
        union(a,b)
        ans += distance
print(f'{ans:.2f}')
