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

def dist(a,b):
    d = sys.maxsize
    for i in range(3):
        d = min(abs(a[i]-b[i]),d)
    return d

n = int(input())
parent = list(range(n+1))
planet = []
for i in range(n):
    x,y,z = map(int,input().split())
    planet.append((i,x,y,z))

edges = []
# 2중 for문 쓰면 n 범위가 10만이라 n^2 메모리초과
# for i in range(n-1):
#     for j in range(i+1,n):
#         edges.append((dist(planet[i],planet[j]),i,j))
for i in range(1,4):
    sort = sorted(planet,key=lambda x : x[i])
    for r in range(n-1):
        d = abs(sort[r][i] - sort[r+1][i])
        edges.append((d,sort[r][0],sort[r+1][0]))
edges.sort()
ans = 0
for d,a,b in edges :
    if find(a) != find(b):
        union(a,b)
        ans += d
print(ans)

