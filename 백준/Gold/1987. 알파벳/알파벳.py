import sys
input = sys.stdin.readline

r,c = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(r)]
point = [[1,0],[0,1],[-1,0],[0,-1]]
visited = [[0]*c for _ in range(r)]
visited_alpha = [0]*26
MAX = 0
def dfs(i,j,cnt) :
    global MAX
    if MAX == 26 :
        return
    
    if cnt > MAX :
        MAX = cnt

    for di,dj in point :
        ni,nj = i+di, j+dj
        if 0<=ni<r and 0<=nj<c and visited_alpha[ord(graph[ni][nj])-65] == 0:
            visited_alpha[ord(graph[ni][nj])-65] = 1
            dfs(ni,nj,cnt+1)
            visited_alpha[ord(graph[ni][nj]) - 65] = 0

    return
lst = set()
lst.add(graph[0][0])
visited_alpha[ord(graph[0][0])-65] = 1
dfs(0,0,1)
print(MAX)
