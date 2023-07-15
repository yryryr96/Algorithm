import sys,copy
from collections import deque
input = sys.stdin.readline

r,c,n = map(int,input().split())
graph = [list(input().rstrip()) for _ in range(r)]
point = [[0,1],[1,0],[0,-1],[-1,0]]

def search() :
    q = set()
    for i in range(r):
        for j in range(c):
            if graph[i][j] == 'O' :
                q.add((i,j))
                for di,dj in point :
                    ni,nj = i+di, j+dj
                    if 0<=ni<r and 0<=nj<c and graph[ni][nj] == '.' :
                        q.add((ni,nj))

    return q

def init() :
    for i in range(r):
        for j in range(c):
            if graph[i][j] == '.' :
                graph[i][j] = 'O'

def bomb(q) :
    for i,j in q :
        graph[i][j] = '.'
    return

q = search()
if n == 1 :
    for i in range(r):
        print(''.join(graph[i]))
else :
    init()
    temp_init = copy.deepcopy(graph)
    bomb(q)
    q = search()
    temp_bomb1 = copy.deepcopy(graph)
    init()
    bomb(q)
    q = search()
    temp_bomb2 = copy.deepcopy(graph)

    # while True :
    #     init()
    #     cnt += 1
    #     if cnt == n: break
    #     bomb(q)
    #     q = search()
    #     cnt += 1
    #     if cnt == n: break
    if n%2 == 0 :
        # print(temp_init)
        for i in range(r):
            print("".join(temp_init[i]))
    elif (n) % 4 == 3 :
        # print(temp_bomb1)
        for i in range(r):
            print("".join(temp_bomb1[i]))
    elif n % 4 == 1 :
        # print(temp_bomb2)
        for i in range(r):
            print("".join(temp_bomb2[i]))

