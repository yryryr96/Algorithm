import sys
input = sys.stdin.readline
N = int(input())
graph = [list(map(int,input().split())) for _ in range(N)]
ans = []
def div(i,j,N):
    color = graph[i][j]

    for k in range(i,i+N):
        for n in range(j,j+N):
            if graph[k][n] != color :
                div(i,j,N//3)
                div(i,j+N//3,N//3)
                div(i,j+(2*N)//3,N//3)
                div(i+N//3,j,N//3)
                div(i+N//3,j+N//3,N//3)
                div(i+N//3,j+(2*N)//3,N//3)
                div(i+(2*N)//3,j,N//3)
                div(i+(2*N)//3,j+N//3,N//3)
                div(i+(2*N)//3,j+(2*N)//3,N//3)
                return
    if color == -1:
        ans.append(-1)
    elif color == 0 :
        ans.append(0)
    else :
        ans.append(1)

div(0,0,N)
print(ans.count(-1))
print(ans.count(0))
print(ans.count(1))