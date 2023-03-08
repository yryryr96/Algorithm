import sys
input = sys.stdin.readline
N, M = map(int,input().split())
lst = list(map(int,input().split()))
ans = 0
for i in range(N-2):
    for j in range(i+1,N-1) :
        for k in range(j+1,N):
            SUM = lst[i] + lst[j] + lst[k]
            if ans < SUM <= M:
                ans = SUM
print(ans)

