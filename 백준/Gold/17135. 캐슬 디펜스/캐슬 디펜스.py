import sys,math,copy
from collections import deque
from itertools import combinations
input = sys.stdin.readline

def dist(x1,y1,x2,y2) :
    return abs(y2-y1) + abs(x2-x1)

n,m,d = map(int,input().split())
temp = [list(map(int,input().split())) for _ in range(n)]
temp.append([2]*m)
hunter = []
for i in range(n+1):
    for j in range(m):
        if temp[i][j] == 2 :
            hunter.append((i,j))

hunter = list(combinations(hunter,3))

def bfs(graph,q):
    global ans
    monster = set()
    while q:
        lst = []
        r, c = q.popleft()

        for i in range(n - 1, -1, -1):
            for j in range(m):
                D = dist(i, j, r, c)
                if graph[i][j] and D <= d:
                    lst.append((D, i, j))

        lst.sort(key=lambda x: (x[0], [x[2]]))
        if lst:
            monster.add((lst[0][1],lst[0][2]))

    ans += len(monster)
    # print(monster)
    for i,j in monster:
        graph[i][j] = 0

def move(graph) :
    tmp = 0
    for i in range(n-1,-1,-1) :
        for j in range(m):
            if graph[i][j] :
                tmp = 1
                if i + 1 >= n :
                    graph[i][j] = 0
                else :
                    graph[i+1][j] = graph[i][j]
                    graph[i][j] = 0
    if tmp == 1:
        return True
    else : return False

MAX = 0

for p in hunter:
    graph = copy.deepcopy(temp)
    ans = 0
    # print(p)
    while True :
        q = deque()
        for k in p:
            q.append(k)
        # for i in range(n):
        #     print(*graph[i])
        # print("######")
        bfs(graph,q)
        if not move(graph) :
            break
    # print(ans)
    MAX = max(ans,MAX)
print(MAX)
