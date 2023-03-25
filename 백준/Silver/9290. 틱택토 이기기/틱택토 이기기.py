import sys
input = sys.stdin.readline

n = int(input())
point = [[0,1],[1,0],[-1,0],[0,-1],[1,1],[1,-1],[-1,1],[-1,-1]]

def search(i,j,t):

    for di,dj in point :
        ni,nj = i+di, j+dj

        if 0<=ni<3 and 0<=nj<3 and graph[ni][nj] == t :
            if 0<=ni+di<3 and 0<=nj+dj<3 :
                graph[ni+di][nj+dj] = t
                return

        elif 0<=ni+di<3 and 0<=nj+dj<3 and graph[ni+di][nj+dj] == t :
            if 0<=ni<3 and 0<=nj<3 :
                graph[ni][nj] = t
                return

for tc in range(1,n+1):
    graph = [list(input().rstrip()) for _ in range(3)]
    team = input().rstrip()
    for i in range(3):
        for j in range(3):
            if graph[i][j] == team :
                search(i,j,team)
                

    print(f'Case {tc}:')
    for i in range(3):
        print(''.join(graph[i]))
