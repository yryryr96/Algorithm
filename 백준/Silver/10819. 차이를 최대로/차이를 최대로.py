N = int(input())
lst = list(map(int,input().split()))
ans = []
lst1 = []
MAX = 0
i = 0

def dfs(v):
    global MAX,SUM

    if len(ans) == N :
        SUM = 0
        for i in range(0,N-1):
            SUM += abs(ans[i] - ans[i+1])
        if SUM > MAX :
            MAX = SUM
        
        return

    for i in range(N):
        if i not in lst1:
            lst1.append(i)
            ans.append(lst[i])
            dfs(i+1)
            lst1.pop()
            ans.pop()

dfs(0)
print(MAX)