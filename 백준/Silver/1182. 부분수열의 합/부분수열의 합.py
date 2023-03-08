N, S = map(int,input().split())
lst = list(map(int,input().split()))
ans = []
cnt = 0

def dfs(idx,SUM):
    global cnt

    if idx >= N :
        return

    SUM += lst[idx]

    if SUM == S:
        cnt += 1

    dfs(idx+1,SUM)
    dfs(idx+1,SUM-lst[idx])

dfs(0,0)
print(cnt)
