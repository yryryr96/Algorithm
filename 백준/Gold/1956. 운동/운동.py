import sys
input = sys.stdin.readline

V,E = map(int,input().split())
distance = [[sys.maxsize]*(V+1) for _ in range(V+1)]

for _ in range(E):
    a,b,c = map(int,input().split())
    distance[a][b] = c

ans = sys.maxsize
for k in range(1,V+1):
    for i in range(1,V+1):
        for j in range(1,V+1):
            if i == j :
                distance[i][j] = 0
                continue
            distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])
for i in range(1,V+1):
    for j in range(1,V+1):
        if i == j : continue
        ans = min(ans,distance[i][j] + distance[j][i])
if ans >= sys.maxsize :
    print(-1)
else : print(ans)