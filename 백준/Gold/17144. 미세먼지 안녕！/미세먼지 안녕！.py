import sys
input = sys.stdin.readline
N,M,T = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]

for i in range(N):
    if graph[i][0] == -1 :
        up = i
        down = i+1
        break

# print(up,down)
def div():
    point = [[1,0],[0,1],[-1,0],[0,-1]]
    temp_list =[[0]*M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if graph[i][j] != 0 and graph[i][j] != -1 :
                temp = 0
                for di,dj in point :
                    ni,nj = i+di, j+dj
                    if 0<=ni<N and 0<=nj<M and graph[ni][nj] != -1 :
                        temp_list[ni][nj] += graph[i][j]//5
                        temp += graph[i][j]//5
                graph[i][j] -= temp

    for i in range(N):
        for j in range(M):
            graph[i][j] += temp_list[i][j]

def move_up():
    point = [[0,1],[-1,0],[0,-1],[1,0]]
    y = up
    x = 1
    before = 0 # 공청기에서 나온 바람은 미세먼지가 없다.
    dir = 0
    while True:
        ni,nj = y+point[dir][0], x+point[dir][1]
        if ni == up and nj == 0 :
            graph[y][x], before = before, graph[y][x]
            break
        if ni<0 or nj<0 or nj>=M :
            dir += 1
            continue
        graph[y][x], before = before, graph[y][x]
        y = ni
        x = nj

def move_down():
    point = [[0,1],[1,0],[0,-1],[-1,0]]
    y = down
    x = 1
    before = 0
    dir = 0
    while True :
        ni,nj = y+point[dir][0], x+point[dir][1]
        if ni == down and nj == 0 :
            graph[y][x], before = before, graph[y][x]
            break
        if ni>=N or nj<0 or nj>=M :
            dir += 1
            continue
        graph[y][x], before = before, graph[y][x]
        y = ni
        x = nj

for _ in range(T):
    div()
    move_up()
    move_down()

ans = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] > 0 :
            ans += graph[i][j]

print(ans)