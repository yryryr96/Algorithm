import sys
input = sys.stdin.readline
C, R = map(int,input().split())
point = [[1,0],[0,1],[-1,0],[0,-1]]
graph = [[0 for _ in range(C)] for _ in range(R)]
graph[0][0] = 1
cnt = 2
temp = 1
K = int(input())
if K > C*R :
    temp = 0
i,j = 0,0
move = 0
while cnt <= C*R :
    di,dj = point[move]
    ni,nj = i+di,j+dj
    if 0<= ni <R and 0<=nj<C and graph[ni][nj] == 0 :
        graph[ni][nj] = cnt
        i,j = ni,nj
        cnt += 1
    else :
        move = (move+1)%4

if temp == 0 :
    print(0)
else:
    for i in range(R):
        for j in range(C):
            if graph[i][j] == K :
                print(j+1,i+1)
