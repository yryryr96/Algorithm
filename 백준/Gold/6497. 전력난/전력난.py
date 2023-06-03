import sys
inpyt = sys.stdin.readline

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    parent[max(a,b)] = min(a,b)

while True :
    m,n = map(int,input().split())
    if m == 0 and n == 0 :
        break

    edges = []
    parent = list(range(m+1))
    total_dist = 0
    for _ in range(n):
        a,b,z = map(int,input().split())
        edges.append((z,a,b))
        total_dist += z

    edges.sort()
    cost = 0
    for dist,a,b in edges :
        if find(a) != find(b):
            union(a,b)
            cost += dist
    print(total_dist - cost)