import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
visited = [[-1]*m for _ in range(n)]
visited_s = [[-1]*m for _ in range(n)]
S_q = deque()
W_q = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == '*':
            W_q.append((i, j))
            visited[i][j] = 0
        elif graph[i][j] == 'S':
            si, sj = i, j
            visited_s[si][sj] = 0
            S_q.append((i,j))
        elif graph[i][j] == 'D':
            ei, ej = i, j
def bfs(s_q, w_q) :
    global W_q, S_q, ans
    ns_q = deque()
    nw_q = deque()
    # print(visited)
    while w_q :
        r,c = w_q.popleft()
        for di,dj in point :
            ni,nj = r+di, c+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == -1 :
                if graph[ni][nj] == '.' or graph[ni][nj] == 'S' :
                    nw_q.append((ni,nj))
                    graph[ni][nj] = '*'
                    visited[ni][nj] = visited[r][c] + 1

    while s_q :
        r,c = s_q.popleft()
        for di,dj in point :
            ni,nj = r+di, c+dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == -1 and visited_s[ni][nj] == -1:
                if graph[ni][nj] == 'D' :
                    return True
                elif graph[ni][nj] == '.' :
                    ns_q.append((ni,nj))
                    visited_s[ni][nj] = visited_s[r][c] + 1

    if not ns_q :
        ans = "KAKTUS"
        return True

    S_q = ns_q
    W_q = nw_q

ans = 0
while ans < 2500 :
    ans += 1
    if bfs(S_q,W_q) :
        print(ans)
        break
else :
    print('KAKTUS')

