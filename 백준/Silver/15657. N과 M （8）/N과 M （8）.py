N,M = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()

ans = []
def dfs(idx):

    if len(ans) == M :
        print(*ans)
        return

    for i in range(idx,N):
        ans.append(lst[i])
        dfs(i)
        ans.pop()

dfs(0)