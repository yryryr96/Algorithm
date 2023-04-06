import sys
from collections import deque
input = sys.stdin.readline

def find(x) :
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    parent[max(a,b)] = min(a,b)

n,m = map(int,input().split())
parent = list(range(n+1))
lst = []
total = 0
ans = 0
for _ in range(m):
    a,b,c,d = map(int,input().split())
    lst.append((c, a, b))
    if d == 1 :
        union(a,b)
        ans += c
    total += c

lst.sort(reverse=True)
for i in range(len(lst)):
    cost,a,b = lst[i]
    if find(a) != find(b) :
        union(a,b)
        ans += cost
    
ans = total - ans
print(ans)
