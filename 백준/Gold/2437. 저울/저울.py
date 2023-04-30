import sys
input = sys.stdin.readline

n = int(input())
lst = sorted(list(map(int,input().split())))
SUM = 1
for i in lst :
    if SUM < i :
        print(SUM)
        break
    SUM += i
else :
    print(SUM)
# 현재까지의 합이 다음 차례 수 보다 작다면 불가