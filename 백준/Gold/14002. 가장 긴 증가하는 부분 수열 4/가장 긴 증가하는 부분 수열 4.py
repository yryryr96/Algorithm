import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
dp = [1]*n

for i in range(n):
    for j in range(i):
        if lst[i] > lst[j] :
            dp[i] = max(dp[i],dp[j] + 1)

max_value = max(dp)
max_idx = dp.index(max_value)
print(max_value)
lis = []
while max_idx >= 0 :
    if dp[max_idx] == max_value :
        lis.append(lst[max_idx])
        max_value -= 1
    max_idx-=1
lis.reverse()

print(*lis)