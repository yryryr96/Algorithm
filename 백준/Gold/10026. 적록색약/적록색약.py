import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [input().rstrip() for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]

visited_true = [[0]*n for _ in range(n)] # 적록색맹
visited_false = [[0]*n for _ in range(n)] # 적록색맹 x (R,G)

def bfs1(i,j,cnt) :
    q = deque()
    q.append((i,j,0,cnt))
    visited_false[i][j] = cnt
    while q :
        i,j,state,cnt = q.popleft()
        # print(i,j,state,cnt)
        for di,dj in point :
            ni, nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<n :
                if not state and not visited_false[ni][nj] :
                    if graph[i][j] == graph[ni][nj] :
                        visited_false[ni][nj] = cnt
                        q.appendleft((ni,nj,0,cnt))

def bfs2(i,j,cnt):
    q = deque()
    q.append((i, j, 1, cnt))
    visited_true[i][j] = cnt
    while q :
        i,j,state,cnt = q.popleft()
        for di,dj in point :
            ni, nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<n and not visited_true[ni][nj] :
                if graph[i][j] == graph[ni][nj] or (graph[i][j] == 'G' and graph[ni][nj] == 'R') or (graph[i][j] == 'R' and graph[ni][nj] == 'G') :
                    visited_true[ni][nj] = cnt
                    q.appendleft((ni,nj,1,cnt))

max_t = max_f = 0

cnt1 = 0
cnt2 = 0
for i in range(n):
    for j in range(n):
        if not visited_false[i][j] :
            cnt1 += 1
            bfs1(i,j,cnt1)
        if not visited_true[i][j] :
            cnt2 += 1
            bfs2(i,j,cnt2)
print(cnt1, cnt2)
