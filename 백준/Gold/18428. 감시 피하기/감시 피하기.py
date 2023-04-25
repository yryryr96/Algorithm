import sys
from itertools import combinations
input = sys.stdin.readline

n = int(input())
graph = [list(map(str,input().split())) for _ in range(n)]
point = [[0,1],[1,0],[0,-1],[-1,0]]
teacher = []
check = set()
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'T' :
            teacher.append((i,j))

def dfs(i,j):
    for di,dj in point :
        ni,nj = i+di,j+dj
        temp = 0
        while 0<=ni<n and 0<=nj<n :
            if graph[ni][nj] == 'S' :
                temp = 1
                break

            elif graph[ni][nj] == 'T' :
                break

            ni+=di
            nj+=dj

        if temp == 1 :
            if i == ni :
                for k in range(min(j,nj)+1,max(j,nj)) :
                    check.add((i,k))
            elif j == nj :
                for k in range(min(i,ni)+1,max(i,ni)) :
                    check.add((k,j))
    return

def find(i,j) :
    for di,dj in point :
        ni,nj = i+di,j+dj
        while 0<=ni<n and 0<=nj<n :
            if graph[ni][nj] == 'S' :
                return False

            elif graph[ni][nj] == 'O' :
                break

            ni+=di
            nj+=dj

    return True

for i,j in teacher :
    dfs(i,j)

if len(check) < 3 :
    for p in check :
        graph[p[0]][p[1]] = 'O'

    for i,j in teacher :
        if not find(i,j) :
            print("NO")
            break
    else :
        print("YES")


else:
    check = list(combinations(check,3))
    for p1,p2,p3 in check :
        temp = 0

        graph[p1[0]][p1[1]] = 'O'
        graph[p2[0]][p2[1]] = 'O'
        graph[p3[0]][p3[1]] = 'O'
        for i,j in teacher :
            if not find(i,j) :
                graph[p1[0]][p1[1]] = 'X'
                graph[p2[0]][p2[1]] = 'X'
                graph[p3[0]][p3[1]] = 'X'
                break
        else :
            temp = 1

        if temp == 1 :
            print("YES")
            break;
    else :
        print("NO")
