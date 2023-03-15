import sys
input = sys.stdin.readline
n,m = map(int,input().split())
lst = list(map(int,input().split()))
INF = int(1e9)
SUM = 0
MIN = INF
end = 0

for start in range(n):
    while SUM < m and end < n :
        SUM += lst[end]
        end += 1

    if SUM >= m :
        length = end - start
        if MIN > length:
            MIN = length

    SUM -= lst[start]

if MIN == INF :
    print(0)
else:
    print(MIN)