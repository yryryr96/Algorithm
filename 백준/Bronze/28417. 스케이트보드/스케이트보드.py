import sys
input = sys.stdin.readline
n = int(input())
ans = 0
for _ in range(n):
    lst1=list(map(int,input().split()))
    lst2 = sorted(lst1[2:])
    a = max(lst1[:2])
    b = lst2[-1]
    c = lst2[-2]
    ans = max(ans,a+b+c)
print(ans)