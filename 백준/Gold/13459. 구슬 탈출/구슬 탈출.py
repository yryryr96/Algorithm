import copy
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(n)]
point = [[-1,0],[0,-1],[1,0],[0,1]] # 상,하,좌,우
ans = sys.maxsize

def dfs(map,d,cnt) : # 그래프, 방향, 몇 번
    global ans
    if cnt == 11 :
        return

    temp = copy.deepcopy(map)
    check = 0
    if d == 0 or d == 1 : # 상,좌
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 'R' or temp[i][j] == 'B' :
                    c = temp[i][j]
                    di,dj = point[d][0],point[d][1]
                    ni,nj = i+di, j+dj
                    ki,kj = i,j
                    if c == 'R' :
                        while (0<=ni<n and 0<=nj<m) :
                            if temp[ni][nj] == '#' or temp[ni][nj] == 'B':
                                temp[i][j] = '.'
                                temp[ki][kj] = c
                                break

                            elif temp[ni][nj] == 'O' :
                                temp[i][j] = '.'
                                check += 1
                                break
                            ki,kj = ni,nj
                            ni += di
                            nj += dj

                    else : # 'C'
                        while (0<=ni<n and 0<=nj<m):
                            if temp[ni][nj] == '#' or temp[ni][nj] == 'R':
                                temp[i][j] = '.'
                                temp[ki][kj] = c
                                break
                            elif temp[ni][nj] == 'O' :
                                temp[i][j] = '.'
                                check -= 1
                                break
                            ki,kj = ni,nj
                            ni+=di
                            nj+=dj

    if d == 2 or d == 3:  # 하,우
        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                if temp[i][j] == 'R' or temp[i][j] == 'B':
                    c = temp[i][j]
                    di, dj = point[d][0], point[d][1]
                    ni, nj = i + di, j + dj
                    ki, kj = i, j
                    if c == 'R':
                        while (0 <= ni < n and 0 <= nj < m):
                            if temp[ni][nj] == '#' or temp[ni][nj] == 'B':
                                temp[i][j] = '.'
                                temp[ki][kj] = c
                                break

                            elif temp[ni][nj] == 'O':
                                temp[i][j] = '.'
                                check += 1
                                break
                            ki, kj = ni, nj
                            ni += di
                            nj += dj

                    else:  # 'C'
                        while (0 <= ni < n and 0 <= nj < m):
                            if temp[ni][nj] == '#' or temp[ni][nj] == 'R':
                                temp[i][j] = '.'
                                temp[ki][kj] = c
                                break
                            elif temp[ni][nj] == 'O':
                                temp[i][j] = '.'
                                check -= 2
                                break
                            ki, kj = ni, nj
                            ni += di
                            nj += dj


    if check == 1 :
        ans = min(ans,cnt)
        return

    elif check < 0 :
        return

    else :
        for i in range(4):
            if i == d or i == (d+2)%4 :
                continue
            dfs(temp,i,cnt+1)


for i in range(4):
    dfs(graph,i,1)

if ans == sys.maxsize :
    print(0)
else :
    print(1)