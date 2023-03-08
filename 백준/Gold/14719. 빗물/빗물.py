import sys
input = sys.stdin.readline
h, w = map(int,input().split())
lst = list(map(int,input().split()))
M_Idx = lst.index(max(lst))
SUM = 0
MAX1 = 0
MAX2 = 0
for i in range(M_Idx):
    if lst[i] > MAX1 :
        MAX1 = lst[i]
    SUM += MAX1 - lst[i]

for j in range(w-1,M_Idx,-1):
    if lst[j] > MAX2:
        MAX2 = lst[j]
    SUM += MAX2 - lst[j]

print(SUM)