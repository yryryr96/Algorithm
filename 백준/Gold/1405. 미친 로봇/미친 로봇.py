import sys
input = sys.stdin.readline

K, E,W,S,N =map(int,input().split())
p = [E*0.01,W*0.01,S*0.01,N*0.01]
point = [[0,1],[0,-1],[1,0],[-1,0]]
ans = 0
def dfs(i,j,visited,total):
    global ans
    if len(visited) == K+1 :
        ans += total
        return

    for di,dj in point:
        ni,nj = i+di,j+dj
        if (ni,nj) not in visited:
            visited.append((ni,nj))
            dfs(ni,nj,visited,total*p[point.index([di,dj])])
            visited.pop()

dfs(0,0,[(0,0)],1)
print(ans)