# 백트래킹
import sys
input = sys.stdin.readline

N, M = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]

house_list = []
chicken_list = []
chl = [] # chosen_chicken_list
ans = sys.maxsize

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            house_list.append((i,j))
        elif graph[i][j] == 2 :
            chicken_list.append((i,j))

def dfs(depth,idx):
    global ans
    if depth == M :
        SUM = 0
        for house in house_list:
            val = sys.maxsize
            for chosen in chl :
                temp = abs(house[0]-chosen[0]) + abs(house[1] - chosen[1])
                if temp < val :
                    val = temp
            SUM += val
        ans = min(ans,SUM)
        return

    for i in range(idx,len(chicken_list)):  # combination 구현
        if chicken_list[i] in chl :
            continue
        chl.append(chicken_list[i])
        dfs(depth+1,i+1)
        chl.pop()

dfs(0,0)
print(ans)