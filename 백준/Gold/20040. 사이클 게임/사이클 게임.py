import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
n,m = map(int,input().split())
parent = list(range(n))
def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x]) # 갱신 하는 과정
    return parent[x]    # 다 갱신하고 리턴

def union(a,b):
    a = find(a)
    b = find(b)
    if a < b :
        parent[a] = b
    else :
        parent[b] = a

ans = 0
for i in range(1,m+1):
    a,b = map(int,input().split())
    if find(a) == find(b):
        ans = i
        break
    union(a, b)


print(ans)