T = int(input())
for tc in range(1,T+1):
    n = int(input())
    graph = [list(map(int,input().split())) for _ in range(n)]
    visited=[0]*n
    MAX = 0
    def dfs(i,per):
        global MAX

        if MAX >= per*100 :
            return

        if i == n :
            MAX = max(MAX,per*100)
            return

        for j in range(n):
            if visited[j] == 0 :
                visited[j] = 1
                dfs(i+1,per*(graph[i][j])/100)
                visited[j] = 0

    dfs(0,1)
    print(f'#{tc} {format(MAX,".6f")}' )