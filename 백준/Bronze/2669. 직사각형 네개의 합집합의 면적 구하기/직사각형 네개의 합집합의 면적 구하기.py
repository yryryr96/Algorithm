graph = [[0 for _ in range(101)] for _ in range(101)]

for _ in range(4):
    j1,i1,j2,i2 = map(int,input().split())

    for i in range(i1,i2):
        for j in range(j1,j2):
            graph[i][j] = 1
ans = 0
for i in range(101):
    for j in range(101):
        if graph[i][j] == 1:
            ans += 1
print(ans)