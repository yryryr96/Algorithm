import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if lst[a] < lst[b] :
        parent[b] = a
    else :
        parent[a] = b

n,m,k = map(int,input().split())
lst = [0] + list(map(int,input().split()))
parent = list(range(n+1))
for _ in range(m):
    v,w = map(int,input().split())
    if find(v) != find(w) :
        union(v,w)

check = set()
for i in range(n+1):
    check.add(find(parent[i]))

ans = 0
for i in check:
    ans += lst[i]

if ans > k :
    print("Oh no")
else:
    print(ans)

