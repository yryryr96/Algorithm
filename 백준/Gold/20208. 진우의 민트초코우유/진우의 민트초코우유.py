import sys
input = sys.stdin.readline

point = [[0,1],[1,0],[-1,0],[0,-1]]

n,m,h = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*(n) for _ in range(n)]
check = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            s,e = i,j
        elif graph[i][j] == 2 :
            check.append([i,j])
MAX = 0
def dfs(i,j,hp,cnt):
    global MAX

    if abs(i-s) + abs(j-e) <= hp :
        MAX = max(MAX,cnt)

    if MAX == len(check) :
        return

    for ni,nj in check :
        if graph[ni][nj] == 2 :
            distance = abs(i-ni) + abs(j-nj)
            if distance <= hp :
                graph[ni][nj] = 0
                dfs(ni,nj,hp-distance+h,cnt+1)
                graph[ni][nj] = 2



dfs(s,e,m,0)
print(MAX)
