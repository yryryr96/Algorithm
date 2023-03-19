import sys
input = sys.stdin.readline

n,m = map(int,input().split())
parent = list(range(n+1))

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

for i in range(m):
    check, a, b = map(int,input().split())
    if check ==  0 :
        union(a,b)
    else :
        if find(a) == find(b):
            print("YES")
        else :
            print('NO')


