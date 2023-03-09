from collections import deque
from itertools import product
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
broken = list(map(str,input().split()))
cnt = abs(100-N)    # 100채널에서 한칸씩 목표 채널로 가는 횟수

for i in range(1000001):
    temp = 1
    for j in str(i):
        if j in broken:
            temp = 0
            break
    if temp == 1:
        cnt = min(cnt,abs(i-N)+len(str(i)))

# 이동가능한 채널로 이동하기 위해서 누른 버튼횟수와 그 채널에서 목표 타겟까지 한칸씩 움직이는 횟수
print(cnt)