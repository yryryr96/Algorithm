import sys
input = sys.stdin.readline

def find(sdoku,r,c,k) :
    point = [[0,0],[0,1],[1,0],[0,-1],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
    i = (r // 3)*3 + 1
    j = (c // 3)*3 + 1
    for di, dj in point:
        ni,nj = i+di,j+dj
        if sdoku[ni][nj] == k :
            return False
    return True

def check_c(sdoku,j,k):
    for i in range(9):
        if sdoku[i][j] == k :
            return False
    return True

def check_r(sdoku,i,k):
    for j in range(9):
        if sdoku[i][j] == k :
            return False
    return True

graph = [list(map(int,input().split())) for _ in range(9)]
zero = []
for i in range(9) :
    for j in range(9):
        if graph[i][j] == 0 :
            zero.append((i,j))
v = len(zero)
def dfs(sdoku,depth):
    global ans,v
    if depth == v:
        for i in range(9):
            print(*sdoku[i])
        exit()

    for k in range(1,10):
        i = zero[depth][0]
        j = zero[depth][1]
        if check_r(sdoku,i,k) and check_c(sdoku,j,k) and find(sdoku,i,j,k):
            sdoku[i][j] = k
            dfs(sdoku,depth+1)
            sdoku[i][j] = 0

dfs(graph,0)
