import sys
input = sys.stdin.readline

N,M,K = map(int,input().split())
point = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
board = [[[] for _ in range(N)] for _ in range(N)]

for i in range(M):
    r,c,m,s,d = map(int,input().split())
    board[r-1][c-1].append([m,s,d])

def move():
    v = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if len(board[i][j]) == 0 :
                continue
            else :
                for m,s,d in board[i][j]:
                    y,x = i,j
                    ni = (y + point[d][0]*s) % N
                    nj = (x + point[d][1]*s) % N
                    v[ni][nj].append([m,s,d])

    for i in range(N):
        for j in range(N):
            if len(v[i][j]) <= 1:
                continue
            else :
                sum_m,sum_s,d_odd,d_even = 0,0,True,True
                num = len(v[i][j])
                for m,s,d in v[i][j]:
                    sum_m += m
                    sum_s += s
                    if d%2 == 1 :
                        d_even = False
                    else:
                        d_odd = False

                v[i][j].clear()
                if sum_m < 5 :
                    continue
                else :
                    if d_odd or d_even :
                        for dir in [0,2,4,6] :
                            v[i][j].append([sum_m//5,sum_s//num,dir])
                    else :
                        for dir in [1,3,5,7] :
                            v[i][j].append([sum_m//5,sum_s//num,dir])
    for i in range(N):
        for j in range(N):
            board[i][j] = v[i][j]

for _ in range(K):
    move()

ans = 0
for i in range(N):
    for j in range(N):
        for matter in board[i][j] :
            ans += matter[0]
print(ans)