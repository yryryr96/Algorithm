import sys
input = sys.stdin.readline

R,C,K = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(R)]
W = int(input())

wall_v = []
for _ in range(W):  # 벽
    a,b,t = map(int,input().split())
    a-=1
    b-=1
    if t == 1 :
        wall_v.append((a,b,a,b+1))
        wall_v.append((a,b+1,a,b))
    else:
        wall_v.append((a,b,a-1,b))
        wall_v.append((a-1,b,a,b))

def left(i,j,v):
    if v == 0 :
        return
    graph[i][j] += v
    visited[i][j] = 1
    # 왼대각위
    if 0<=i-1<R and 0<=j<C and 0<=i-1<R and 0<=j-1<C :
        if visited[i-1][j-1] == 0 :
            if (i,j,i-1,j) in wall_v or (i-1,j,i-1,j-1) in wall_v :
                pass
            else :
                left(i - 1, j - 1, v - 1)
    # 왼
    if 0 <= i < R and 0 <= j - 1 < C :
        if visited[i][j-1] == 0 :
            if (i,j,i,j-1) in wall_v :
                pass
            else :
                left(i,j-1,v-1)
    # 왼대각 아래

    if 0 <= i + 1 < R and 0 <= j < C and 0 <= i + 1 < R and 0 <= j - 1 < C:
        if visited[i+1][j-1] == 0 :
            if (i,j,i+1,j) in wall_v or (i+1,j,i+1,j-1) in wall_v :
                pass
            else:
                left(i+1,j-1,v-1)

def right(i,j,v):
    if v == 0:
        return
    graph[i][j] += v
    visited[i][j] = 1
    # 오른대각위
    if 0 <= i - 1 < R and 0 <= j < C and 0 <= i - 1 < R and 0 <= j + 1 < C:
        if visited[i - 1][j + 1] == 0:
            if (i,j,i-1,j) in wall_v or (i-1,j,i-1,j+1) in wall_v :
                pass
            else:
                right(i - 1, j + 1, v - 1)
    # 오른
    if 0 <= i < R and 0 <= j + 1 < C :
        if visited[i][j + 1] == 0:
            if (i,j,i,j+1) in wall_v :
                pass
            else:
                right(i, j + 1, v - 1)
    # 오른대각 아래
    if 0 <= i + 1 < R and 0 <= j < C and 0 <= i + 1 < R and 0 <= j + 1 < C:
        if visited[i + 1][j + 1] == 0:
            if (i,j,i+1,j) in wall_v or (i+1,j,i+1,j+1) in wall_v :
                pass
            else:
                right(i + 1, j + 1, v - 1)

def up(i,j,v):
    if v == 0 :
        return
    graph[i][j] += v
    visited[i][j] = 1
    # 왼대각위
    if 0 <= i < R and 0 <= j - 1 < C and 0 <= i - 1 < R and 0 <= j - 1 < C:
        if visited[i-1][j-1] == 0 :
            if (i,j,i,j-1) in wall_v or (i,j-1,i-1,j-1) in wall_v :
                pass
            else:
                up(i-1,j-1,v-1)
    # 위
    if 0 <= i - 1 < R and 0 <= j < C :
        if  visited[i-1][j] == 0 :
            if (i,j,i-1,j) in wall_v :
                pass
            else:
                up(i-1,j,v-1)
    # 오른 대각위
    if 0 <= i < R and 0 <= j + 1 < C and 0 <= i - 1 < R and 0 <= j + 1 < C:
        if visited[i-1][j+1] == 0 :
            if (i,j,i,j+1) in wall_v or (i,j+1,i-1,j+1) in wall_v :
                pass
            else:
                up(i-1,j+1,v-1)

def down(i,j,v):
    if v == 0:
        return
    graph[i][j] += v
    visited[i][j] = 1
    # 왼대각아래
    if 0 <= i < R and 0 <= j - 1 < C and 0 <= i + 1 < R and 0 <= j - 1 < C:
        if visited[i + 1][j - 1] == 0:
            if (i,j,i,j-1) in wall_v or (i,j-1,i+1,j-1) in wall_v :
                pass
            else:
                down(i + 1, j - 1, v - 1)
    # 아래
    if 0 <= i + 1 < R and 0 <= j < C :
        if visited[i + 1][j] == 0:
            if (i,j,i+1,j) in wall_v :
                pass
            else:
                down(i+1, j, v - 1)
    # 오른 대각 아래
    if 0 <= i < R and 0 <= j + 1 < C and 0 <= i + 1 < R and 0 <= j + 1 < C:
        if visited[i + 1][j + 1] == 0:
            if (i,j,i,j+1) in wall_v or (i,j+1,i+1,j+1) in wall_v :
                pass
            else:
                down(i + 1, j + 1, v - 1)

def control(temp):
    point = [[0,1],[1,0],[-1,0],[0,-1]]

    for i in range(R):
        for j in range(C):
            if graph[i][j] != 0:
                for di,dj in point :
                    ni,nj = i+di,j+dj
                    if 0<=ni<R and 0<=nj<C and graph[i][j] > graph[ni][nj] :
                        if (i,j,ni,nj) in wall_v : continue
                        temp[i][j] -= ( (graph[i][j]- graph[ni][nj]) // 4 )
                        temp[ni][nj] += ( (graph[i][j]- graph[ni][nj]) // 4 )

    for i in range(R):
        for j in range(C):
            graph[i][j] = graph[i][j] + temp[i][j]

    return

check = []
heater = []
for i in range(R):
    for j in range(C):
        if graph[i][j] != 0 :
            if graph[i][j] == 5 :
                check.append((i,j))
                graph[i][j] = 0
            else:
                heater.append((i, j, graph[i][j]))
                graph[i][j] = 0
def square():
    for j in range(C):
        for i in [0,R-1] :
            if graph[i][j] != 0 :
                graph[i][j] -= 1

    for i in range(1,R-1):
        for j in [0,C-1] :
            if graph[i][j] != 0 :
                graph[i][j] -= 1

    return

choco = 0
while True:

    for i,j,t in heater :
        visited = [[0]*C for _ in range(R)]
        if t == 1 :
            right(i,j+1,5)
        elif t == 2:
            left(i,j-1,5)
        elif t == 3:
            up(i-1,j,5)
        elif t == 4:
            down(i+1,j,5)

    temp = [[0] * C for _ in range(R)]
    control(temp)
    square()
    choco += 1

    if choco > 100 :
        break

    k = 1
    for i,j in check:
        if graph[i][j] < K :
            k = 0
            break

    if k == 1:
        break

print(choco)