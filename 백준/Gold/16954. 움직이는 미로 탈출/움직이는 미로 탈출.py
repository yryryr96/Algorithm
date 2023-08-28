import sys
from collections import deque
input = sys.stdin.readline

graph = [list(input().rstrip()) for _ in range(8)]
point = [[0,0],[-1,0],[0,-1],[1,0],[0,1],[1,1],[1,-1],[-1,-1],[-1,1]]

def move_wall(player) :

    nq = set()
    while player :
        i,j = player.popleft()
        for di,dj in point :
            ni,nj = i+di, j+dj
            if not (0<=ni<8 and 0<=nj<8) : continue
            if graph[ni][nj] != '#' :
                if ni == 0 and nj == 7 :
                    print(1)
                    exit()
                nq.add((ni,nj))

    for i in range(7,-1,-1) :
        for j in range(8) :
            if graph[i][j] == '#' :
                if i+1 < 8 :
                    if (i+1,j) in nq : nq.remove((i+1,j))
                    graph[i+1][j] = graph[i][j]
                    graph[i][j] = '.'

                else :
                    graph[i][j] = '.'

    nq = deque(nq)
    return nq


q = deque()
q.append((7,0))

while q :
    nq = move_wall(q)
    q = nq
    # for i in range(8):
    #     print(*graph[i])
    # # print(q)
else :
    print(0)
