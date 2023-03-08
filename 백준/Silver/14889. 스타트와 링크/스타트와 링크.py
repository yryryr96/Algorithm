import sys
input = sys.stdin.readline

N = int(input())
graph = [list(map(int,input().split())) for _ in range(N)]
start = []
MIN = sys.maxsize

def dfs(idx):
    global MIN
    if len(start) == N//2:
        t1,t2 = 0,0
        link = []
        for i in range(N):
            if i not in start :
                link.append(i)

        for i in range(N//2-1):
            for j in range(i+1,N//2):
                t1 += graph[start[i]][start[j]] + graph[start[j]][start[i]]
                t2 += graph[link[i]][link[j]] + graph[link[j]][link[i]]
        ans = abs(t1-t2)
        if MIN > ans :
            MIN = ans
        return

    for i in range(N):
        if i in start: continue
        if len(start)>0 and start[len(start)-1] > i : continue
        start.append(i)
        dfs(idx+1)
        start.pop()
dfs(0)
print(MIN)