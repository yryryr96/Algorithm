import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

dp = [0]*(n+1)
q = deque()
q.append(n)
while q:
    now = q.popleft()

    if now == 1 :
        print(dp[1])
        break

    if now%2 == 0:
        a = now//2
        if dp[a] == 0 or (dp[a] != 0 and dp[now] + 1 < dp[a]):
            q.append(a)
            dp[a] = dp[now] + 1

    if now%3 == 0 :
        b = now // 3
        if dp[b]== 0 or (dp[b] != 0 and dp[now] + 1 < dp[b]):
            q.append(b)
            dp[b] = dp[now] + 1
    if dp[now-1] == 0 or (dp[now-1] != 0 and dp[now-1] > dp[now] + 1) :
        q.append(now-1)
        dp[now-1] = dp[now] + 1

