import sys
input = sys.stdin.readline
N = int(input().rstrip())
graph = [[0 for _ in range(1001)] for _ in range(1001)]
for n in range(1,N+1):
    x1,y1,w,h = map(int,input().split())

    for i in range(y1,y1+h):
        for j in range(x1,x1+w):
            graph[i][j] = n

for n in range(1,N+1):
    cnt = 0
    for i in range(1001):
        for j in range(1001):
            if graph[i][j] == n:
                cnt += 1
    print(cnt)