import sys
input = sys.stdin.readline
n,m = map(int,input().split())
lst = list(map(int,input().split()))
end = 0
SUM = 0
cnt = 0

for start in range(n):
    while SUM < m and end < n:
        SUM += lst[end]
        end += 1

    if SUM == m :
        cnt += 1

    SUM -= lst[start]

print(cnt)