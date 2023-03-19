import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
MAX = 0
def check1(r,c,visited):
    if r+1 == n or c+1 == m :
        return False
    if visited[r][c] == 1 or visited[r+1][c] == 1 or visited[r][c+1] == 1 :
        return False
    visited[r][c] = 1
    visited[r+1][c] = 1
    visited[r][c+1] = 1
    return True

def check2(r,c,visited):
    if r+1 == n or c-1 < 0 :
        return False
    if visited[r][c] == 1 or visited[r+1][c] == 1 or visited[r][c-1] == 1 :
        return False
    visited[r][c] = 1
    visited[r+1][c] = 1
    visited[r][c-1] = 1
    return True

def check3(r,c,visited):
    if r-1 < 0 or c+1 == m :
        return False
    if visited[r][c] == 1 or visited[r-1][c] == 1 or visited[r][c+1] == 1 :
        return False
    visited[r][c] = 1
    visited[r-1][c] = 1
    visited[r][c+1] = 1
    return True

def check4(r,c,visited):
    if r-1 < 0 or c-1 < 0 :
        return False
    if visited[r][c] == 1 or visited[r-1][c] == 1 or visited[r][c-1] == 1 :
        return False
    visited[r][c] = 1
    visited[r-1][c] = 1
    visited[r][c-1] = 1
    return True

def solve(i,j,visited,cnt):
    global MAX
    if j == m :
        i += 1
        j = 0
    if i == n :
        MAX = max(MAX,cnt)
        return

    if check1(i,j,visited):
        solve(i, j + 1, visited, cnt + 2 * graph[i][j] + graph[i + 1][j] + graph[i][j + 1])
        visited[i][j] = 0
        visited[i + 1][j] = 0
        visited[i][j + 1] = 0

    if check2(i,j,visited):
        solve(i, j + 1, visited, cnt + 2 * graph[i][j] + graph[i + 1][j] + graph[i][j -1])
        visited[i][j] = 0
        visited[i + 1][j] = 0
        visited[i][j - 1] = 0

    if check3(i,j,visited):
        solve(i, j + 1, visited, cnt + 2 * graph[i][j] + graph[i - 1][j] + graph[i][j +1])
        visited[i][j] = 0
        visited[i - 1][j] = 0
        visited[i][j + 1] = 0

    if check4(i,j,visited):
        solve(i, j + 1, visited, cnt + 2 * graph[i][j] + graph[i - 1][j] + graph[i][j -1])
        visited[i][j] = 0
        visited[i - 1][j] = 0
        visited[i][j - 1] = 0

    solve(i,j+1,visited,cnt)

solve(0,0,visited,0)

print(MAX)

