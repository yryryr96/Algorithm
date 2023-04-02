import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
dp = [1]*(n)

for i in range(n):
    for j in range(i):
        if lst[i] > lst[j] :
            dp[i] = max(dp[i],dp[j]+1)

print(max(dp))

MAX = max(dp)
MAX_idx = dp.index(MAX)
lis = []
while MAX_idx >= 0 :
    if dp[MAX_idx] == MAX :
        lis.append(lst[MAX_idx])
        MAX -= 1
    MAX_idx -= 1
print(*list(reversed(lis)))

