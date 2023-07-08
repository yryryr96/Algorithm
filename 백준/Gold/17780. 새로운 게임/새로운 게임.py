import sys
input = sys.stdin.readline

n,k = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
point = [[0,1],[0,-1],[-1,0],[1,0]]
chess_graph = [[[] for _ in range(n)] for _ in range(n)]
chess_info = [0]*k


def move(num):
    i,j,d = chess_info[num]
    if num != chess_graph[i][j][0] :
        return False

    ni,nj = i + point[d][0], j + point[d][1]
    if ni < 0 or ni>=n or nj <0 or nj>=n or graph[ni][nj] == 2 :
        if d == 0 or d == 2 :
            nd = d+1
        else :
            nd = d-1
        chess_info[num][2] = nd
        ni,nj = i + point[nd][0], j + point[nd][1]
        if ni < 0 or ni >= n or nj < 0 or nj >= n or graph[ni][nj] == 2:
            return False

    if graph[ni][nj] == 1 :
        chess_graph[i][j].reverse()

    for m in chess_graph[i][j] :
        chess_graph[ni][nj].append(m)
        chess_info[m][0], chess_info[m][1] = ni,nj

    chess_graph[i][j] = []
    if len(chess_graph[ni][nj]) >= 4 :
        return True
    return False


for i in range(k):
    y,x,d = map(int,input().split())
    chess_graph[y-1][x-1].append(i)
    chess_info[i] = [y-1,x-1,d-1]
#
# print(chess_graph)
# print(chess_info)

cnt = 0
while cnt < 1000:
    cnt += 1
    for i in range(k):
        if move(i) :
            print(cnt)
            exit()
print(-1)