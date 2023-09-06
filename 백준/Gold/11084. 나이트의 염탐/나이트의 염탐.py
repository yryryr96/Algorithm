import sys
from collections import deque
input = sys.stdin.readline

r,c = map(int,input().split())
point = [(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]
visited = [[-1]*c for _ in range(r)]
dp = [[0]*c for _ in range(r)]
dp[0][0] = 1
k = 1000000009

q = deque()
q.append((0,0))
visited[0][0] = 0
cnt = 0
while q :
    i,j = q.popleft()
    for di,dj in point :
        ni,nj = i+di, j+dj
        if not(0<=ni<r and 0<=nj<c) : continue
        if visited[ni][nj] == -1 or visited[ni][nj] == visited[i][j] + 1 :
            dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % k
            if visited[ni][nj] == -1 :
                visited[ni][nj] = visited[i][j] + 1
                q.append((ni,nj))

if visited[r-1][c-1] == -1 : print("None")
else : print(visited[r-1][c-1],dp[r-1][c-1])



