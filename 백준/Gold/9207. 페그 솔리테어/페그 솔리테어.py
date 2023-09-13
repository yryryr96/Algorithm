import sys, copy
input = sys.stdin.readline

t = int(input())
point = [(1, 0), (0, 1), (-1, 0), (0, -1)]
def check(i,j):
    for di, dj in point:
        ni, nj = i + di, j + dj
        if not (0<=ni<5 and 0<=nj<9 and 0<=ni+di<5 and 0<=nj+dj<9) : continue
        if graph[ni][nj] == 'o' and graph[ni+di][nj+dj] == '.' :
            return True

    return False

def make_candi(graph) :

    candi = []
    for i in range(5):
        for j in range(9):
            if graph[i][j] == 'o':
                if check(i, j): candi.append((i, j))
    return candi

def dfs(pin,cnt,graph):
    global MIN_pin, MIN_cnt

    if pin < MIN_pin :
        MIN_pin = pin
        MIN_cnt = cnt

    elif pin == MIN_pin :
        MIN_cnt = min(cnt,MIN_cnt)

    candi = make_candi(graph)

    for i,j in candi :
        for di, dj in point :
            ni,nj = i+di, j+dj
            if not (0<=ni<5 and 0<=nj<9 and 0<=ni+di<5 and 0<=nj+dj<9) : continue
            if graph[ni][nj] == 'o' and graph[ni+di][nj+dj] == '.' :
                graph[i][j] = '.'
                graph[ni][nj] = '.'
                graph[ni+di][nj+dj] = 'o'
                dfs(pin-1, cnt+1, graph)
                graph[ni + di][nj + dj] = '.'
                graph[ni][nj] = 'o'
                graph[i][j] = 'o'




for tc in range(1,t+1):
    graph = [list(input().rstrip()) for _ in range(5)]
    MIN_pin = 0
    MIN_cnt = 0
    for i in range(5):
        for j in range(9) :
            if graph[i][j] == 'o' : MIN_pin += 1

    dfs(MIN_pin, MIN_cnt, graph)

    print(MIN_pin, MIN_cnt)

    if tc != t :
        a = input().rstrip()
        continue
