N = int(input())
graph = [[0 for _ in range(101)] for _ in range(101)]
point = [[0,1],[1,0],[-1,0],[0,-1]]

cnt = 0
ans = 0
def search(i,j):
    global cnt,ans
    cnt = 0
    for di,dj in point :
        ni,nj = i+di, j+dj
        if graph[ni][nj] == 0 :
            cnt += 1

    if cnt == 1:
        ans += 1

    elif cnt == 2:
        ans += 2



for _ in range(N):
    x,y = map(int,input().split())

    for i in range(y,y+10):
        for j in range(x,x+10):
            graph[i][j] = 1

for i in range(101):
    for j in range(101):
        if graph[i][j] == 1:
            search(i,j)

print(ans)
