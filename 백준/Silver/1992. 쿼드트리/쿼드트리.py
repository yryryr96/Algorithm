N = int(input())
graph = [list(map(int,input())) for _ in range(N)]
ans = []
def div(i,j,N):
    color = graph[i][j]

    for k in range(i,i+N):
        for n in range(j,j+N):
            if graph[k][n] != color :
                ans.append('(')
                div(i,j,N//2)
                div(i,j+N//2,N//2)
                div(i+N//2,j,N//2)
                div(i+N//2,j+N//2,N//2)
                ans.append(')')
                return
    ans.append(color)

div(0,0,N)
print(''.join(map(str,ans)))