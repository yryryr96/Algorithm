import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if a in Trueman or b in Trueman :
        parent[a] = parent[b] = l
    else:
        parent[max(a,b)] = min(a,b)

n,m = map(int,input().split())
parent = list(range(n+1))
Trueman = list(map(int,input().split()))
t = Trueman[0]
if t == 0 :
    print(m)
    exit()
Trueman = Trueman[1:]
l = min(Trueman)
ans = 0
parties = []
for _ in range(m):
    party = list(map(int,input().split()))[1:]
    parties.append(party)

    for i in range(len(party)-1):
        union(party[i],party[i+1])

for party in parties:
    for i in range(len(party)):
        if find(party[i]) in Trueman :
            break
    else:
        ans += 1

print(ans)