import sys, copy
input = sys.stdin.readline

n = int(input())
mp,mf,ms,mv = map(int,input().split())
MIN = sys.maxsize

graph = [list(map(int,input().split())) for _ in range(n)]
visited = [0]*n

ans = []
def dfs(keys,lst,st):
    global ans, MIN
    if keys[4] > MIN :
        return

    if keys and keys[0] >= mp and keys[1] >= mf and keys[2] >= ms and keys[3] >= mv :
        if MIN > keys[4] :
            MIN = keys[4]
            ans.append((keys[4],copy.deepcopy(lst)))
        return

    for i in range(st,n) :
        for j in range(5):
            keys[j] += graph[i][j]
        lst.append(i+1)
        dfs(keys,lst,i+1)
        for j in range(5) :
            keys[j] -= graph[i][j]
        lst.pop()

dfs([0,0,0,0,0],[],0)
if ans :
    ans.sort()
    print(MIN)
    print(*ans[0][1])

else :
    print(-1)