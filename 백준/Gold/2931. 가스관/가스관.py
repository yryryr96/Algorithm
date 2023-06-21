import sys
from collections import deque
input = sys.stdin.readline

R,C = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(R)]
visited = [[0]*C for _ in range(R)]
point_dic = {'|' : [[-1,0],[1,0]], '-' : [[0,1],[0,-1]], '+' : [[-1,0],[0,1],[1,0],[0,-1]], '1' : [[0,1],[1,0]], '2' : [[-1,0],[0,1]], '3' : [[-1,0],[0,-1]], '4' : [[1,0],[0,-1]]}
point = [[-1,0],[0,1],[1,0],[0,-1]]
# print(point_dic)
check = []
point_check = []
def BFS(i,j) :
    global check

    visited[i][j] = 1
    q = deque()
    q.append((i,j))

    while q :
        r,c = q.popleft()

        for di,dj in point_dic[graph[r][c]] :
            ni,nj = r+di, c+dj
            if 0<=ni<R and 0<=nj<C and visited[ni][nj] == 0 :
                if graph[ni][nj] == '.' :
                    check.append((ni,nj))
                    continue
                elif graph[ni][nj] == 'Z' or graph[ni][nj] == 'M' :
                    visited[ni][nj] = 1
                    continue

                q.append((ni,nj))
                visited[ni][nj] = 1

def final_check(i,j) :
    global point_check
    pc = []
    for di,dj in point :
        ni,nj = i+di, j+dj
        # print(ni,nj)
        if 0<=ni<R and 0<=nj<C and graph[ni][nj] != '.'  :
            if graph[ni][nj] != 'Z' and graph[ni][nj] != 'M' :
                if [i-ni, j-nj] in point_dic[graph[ni][nj]] :
                    point_check.append([di,dj])

            elif graph[ni][nj] == 'Z' or graph[ni][nj] == 'M' :
                pc.append([ni-i,nj-j])

    if not point_check :
        for v in pc :
            point_check.append(v)


for i in range(R):
    for j in range(C):
        temp = 0
        if graph[i][j] == 'M' or graph[i][j] == 'Z' :
            temp = 1
            visited[i][j] = 1
            for di,dj in point :
                ni,nj = i+di, j+dj
                if 0<=ni<R and 0<=nj<C and graph[ni][nj] != 'Z' and graph[ni][nj] != 'M' and graph[ni][nj] != '.' :
                    visited[ni][nj] = 1
                    BFS(ni,nj)
                    break
            break

    if temp :
        final_check(check[0][0],check[0][1])
        # print(point_check)
        for key,value in point_dic.items() :
            if point_check == value :
                print(check[0][0]+1,check[0][1]+1,key)
        break


