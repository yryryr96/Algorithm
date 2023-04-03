import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    parent[max(a,b)] = min(a,b)

V,E = map(int,input().split())
parent = list(range(V+1))
edges = []
for _ in range(E):
    a,b,c = map(int,input().split())
    edges.append((c,a,b))

edges.sort()

ans = 0
for i in range(E):
    c,a,b = edges[i]
    if find(a) != find(b) :
        union(a,b)
        ans += c
print(ans)