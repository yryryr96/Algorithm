import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
lst = list(map(int,input().split()))
cnt = 1
MAX1,MAX2 = 1,1
for i in range(N-1):
    if lst[i+1] - lst[i] >= 0 :
        cnt += 1
        if cnt >= MAX1 :
            MAX1 = cnt
    else :
        cnt = 1

cnt = 1
for j in range(N-1):
    if lst[j+1] - lst[j] <= 0:
        cnt += 1
        if cnt >= MAX2 :
            MAX2 = cnt
    else:
        cnt = 1

print(max(MAX1,MAX2))