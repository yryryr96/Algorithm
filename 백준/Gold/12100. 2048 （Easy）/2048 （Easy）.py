import sys,copy
input = sys.stdin.readline

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[-1,0],[0,-1]]
MAX = 0
# 각 방향별 끝으로 이동
def dfs(map,dir,cnt):
    global MAX
    temp = copy.deepcopy(map)
    if cnt == 6 :
        for i in range(n):
            for j in range(n):
                if temp[i][j] > MAX :
                    MAX = temp[i][j]

        return

    visited = [[0]*n for _ in range(n)]
    if dir == 2 or dir == 3:
        for i in range(n):
            for j in range(n):
                if temp[i][j] != 0 :
                    k = temp[i][j]
                    ni,nj = i+point[dir][0],j+point[dir][1]
                    ki,kj = i,j
                    while 0<=ni<n and 0<=nj<n :

                        if temp[ni][nj] == k and visited[ni][nj] == 0:
                            temp[i][j] = 0
                            temp[ni][nj] = 2*k
                            visited[ni][nj] = 1
                            break

                        elif (temp[ni][nj] != 0 and temp[ni][nj] != k) or visited[ni][nj] == 1 :
                            temp[i][j] = 0
                            temp[ki][kj] = k
                            break

                        ki, kj = ni, nj
                        ni+=point[dir][0]
                        nj+=point[dir][1]
                    else :
                        temp[i][j] = 0
                        temp[ki][kj] = k

    elif dir == 0 or dir == 1 :
        for i in range(n-1,-1,-1) :
            for j in range(n-1,-1,-1):
                if temp[i][j] != 0 :
                    k = temp[i][j]
                    ni, nj = i + point[dir][0], j + point[dir][1]
                    ki, kj = i, j
                    while 0 <= ni < n and 0 <= nj < n:

                        if temp[ni][nj] == k and visited[ni][nj] == 0:
                            temp[i][j] = 0
                            temp[ni][nj] = 2 * k
                            visited[ni][nj] = 1
                            break

                        elif (temp[ni][nj] != 0 and temp[ni][nj] != k) or visited[ni][nj] == 1:
                            temp[i][j] = 0
                            temp[ki][kj] = k
                            break

                        ki, kj = ni, nj
                        ni += point[dir][0]
                        nj += point[dir][1]
                    else:
                        temp[i][j] = 0
                        temp[ki][kj] = k

    for i in range(4):
        dfs(temp,i,cnt+1)
    return

lst = graph
for i in range(4):
    dfs(lst,i,1)
print(MAX)
