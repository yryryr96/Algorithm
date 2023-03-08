N, M = map(int,input().split())
r,c,dir = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
point = [[-1,0],[0,1],[1,0],[0,-1]] # 북,동,남,서

def move():
    global cnt,r,c,dir

    while True:
        if graph[r][c] == 0:
            graph[r][c] = 2

        else :
            pass
        cnt = 0
        for di,dj in point :
            ni,nj = r+di, c+dj
            if 0<=ni<N and 0<=nj<M and graph[ni][nj] == 0 :
                cnt += 1

        if cnt == 0:
            ki,kj = r + point[(dir+2)%4][0], c + point[(dir+2)%4][1]
            if 0<=ki<N and 0<=kj<M and graph[ki][kj] != 1 :
                r,c = ki,kj
            else:
                return

        else:
            dir = (dir+3)%4
            ki,kj = r + point[dir][0], c + point[dir][1]
            if 0<=ki<N and 0<=kj<M and graph[ki][kj] == 0 :
                r,c = ki,kj

move()
ans = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 2:
            ans += 1
print(ans)
