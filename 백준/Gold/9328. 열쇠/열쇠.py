import sys
from collections import deque
input = sys.stdin.readline

def find_enter():
    global ans
    for j in range(m):
        a = graph[0][j]
        b = graph[n - 1][j]
        if a.isalpha():
            if a.isupper() and a.lower() in KEY :
                enter.add((0,j))
            elif a.islower() :
                enter.add((0,j))
                KEY.add(graph[0][j])
        elif a == '.' :
            enter.add((0,j))
        elif a == '$' :
            ans += 1
            enter.add((0,j))
            graph[0][j] = '.'

        if b.isalpha():
            if b.isupper() and b.lower() in KEY :
                enter.add((n-1,j))
            elif b.islower() :
                enter.add((n-1,j))
                KEY.add(graph[n-1][j])
        elif b == '.' :
            enter.add((n-1,j))
        elif b == '$' :
            ans += 1
            enter.add((n-1,j))
            graph[n-1][j] = '.'

    for i in range(n):
        a = graph[i][0]
        b = graph[i][m-1]
        if a.isalpha():
            if a.isupper() and a.lower() in KEY:
                enter.add((i, 0))
            elif a.islower():
                enter.add((i, 0))
                KEY.add(graph[i][0])
        elif a == '.':
            enter.add((i, 0))
        elif a == '$' :
            ans += 1
            enter.add((i,0))
            graph[i][0] = '.'

        if b.isalpha():
            if b.isupper() and b.lower() in KEY:
                enter.add((i,m-1))
            elif b.islower():
                enter.add((i, m-1))
                KEY.add(graph[i][m-1])
        elif b == '.':
            enter.add((i,m-1))
        elif b == '$' :
            ans += 1
            enter.add((i,m-1))
            graph[i][m-1] = '.'

def bfs():
    global ans
    visited =[[0]*m for _ in range(n)]
    q = deque(list(enter))

    while q :
        now = q.popleft()

        for di,dj in point :
            ni,nj = now[0] + di, now[1] + dj
            if 0<=ni<n and 0<=nj<m and visited[ni][nj] == 0 :
                g = graph[ni][nj]
                visited[ni][nj] = 1
                if g == '$' :
                    ans += 1
                    graph[ni][nj] = '.'
                    q.append((ni,nj))
                elif g.isalpha():
                    if g.isupper() and g.lower() in KEY :
                        q.append((ni,nj))
                    elif g.islower():
                        KEY.add(g)
                        q.append((ni,nj))

                elif g == '.':
                    q.append((ni,nj))
                else:
                    continue


T = int(input())
for tc in range(T):
    n,m = map(int,input().split())
    graph = [list(input().rstrip()) for _ in range(n)]
    point = [[0,1],[1,0],[-1,0],[0,-1]]
    KEY = set(input().rstrip())
    enter = set()
    ans = 0
    check = sys.maxsize

    while True:
        find_enter()
        bfs()
        temp = len(KEY) + ans
        if temp == check :
            break
        check = temp


    print(ans)