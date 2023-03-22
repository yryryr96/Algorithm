import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
# MIN = sys.maxsize
# def dfs(n,money,i,j):
#     global MIN
#     if i == n :
#         if MIN > money :
#             MIN = money
#         return
#
#     if money > MIN :
#         return
#
#     for col in range(3):
#         if col != j :
#             dfs(n,money+graph[i][j],i+1,col)
# for j in range(3):
#     dfs(n,0,0,j)
# print(MIN)
ans = [[0]*3 for _ in range(n+1)]
for i in range(1,n+1):
    ans[i][0] = min(ans[i - 1][1], ans[i - 1][2]) + graph[i - 1][0]
    ans[i][1] = min(ans[i - 1][0], ans[i - 1][2]) + graph[i - 1][1]
    ans[i][2] = min(ans[i - 1][0], ans[i - 1][1]) + graph[i - 1][2]
print(min(ans[n][0],ans[n][1],ans[n][2]))



