import sys,heapq
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [input().rstrip() for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
tr = set()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'g' :
            for di,dj in point :
                ni,nj = i+di, j+dj
                if 0<=ni<n and 0<=nj<m and graph[ni][nj]=='.':
                    tr.add((ni,nj))

        elif graph[i][j] == 'F' :
            ei,ej = i,j

        elif graph[i][j] == 'S' :
            si,sj = i,j

def dijk():
    global si,sj,ei,ej,tr
    q = []
    visited = [[[sys.maxsize,sys.maxsize] for _ in range(m)] for _ in range(n)]
    visited[si][sj][0] = visited[si][sj][1] = 0
    heapq.heappush(q,(0,0,si,sj))

    while q :
        tc, ta, i, j = heapq.heappop(q)
        if i == ei and j == ej :
            print(visited[ei][ej][0], visited[ei][ej][1])
            return

        if tc > visited[i][j][0] or (tc == visited[i][j][0] and ta > visited[i][j][1]): continue

        for di,dj in point :
            ni,nj = i+di, j+dj
            if 0<=ni<n and 0<=nj<m :
                if graph[ni][nj] == 'g' :
                    if tc+1 < visited[ni][nj][0] :
                        visited[ni][nj][0],visited[ni][nj][1] = tc+1,ta
                        heapq.heappush(q,(tc+1,ta,ni,nj))
                    elif tc+1 == visited[ni][nj][0] and ta < visited[ni][nj][1] :
                        visited[ni][nj][1] = ta
                        heapq.heappush(q,(tc+1,ta,ni,nj))

                elif graph[ni][nj] == '.' or graph[ni][nj] == 'F':
                    if tc < visited[ni][nj][0] :
                        if (ni,nj) in tr :
                            visited[ni][nj][0],visited[ni][nj][1] = tc,ta+1
                            heapq.heappush(q,(tc,ta+1,ni,nj))
                        else :
                            visited[ni][nj][0],visited[ni][nj][1] = tc,ta
                            heapq.heappush(q,(tc,ta,ni,nj))
                    elif tc == visited[ni][nj][0] and ta < visited[ni][nj][1]:
                        if (ni,nj) in tr and ta+1 < visited[ni][nj][1] :
                            visited[ni][nj][0],visited[ni][nj][1] = tc,ta+1
                            heapq.heappush(q,(tc,ta+1,ni,nj))

dijk()