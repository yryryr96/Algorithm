import sys

input = sys.stdin.readline
N,K = map(int,input().split())
cnt = 0
coins = []
for i in range(N):
    a = int(input())
    coins.append(a)

coins.reverse()

for coin in coins :
    if K // coin >= 1 :
        cnt += K//coin
        K = K - coin*(K//coin)
    elif K // coin < 1 :
        pass

print(cnt)

