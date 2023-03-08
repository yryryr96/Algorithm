from itertools import permutations
import sys
input = sys.stdin.readline

N = int(input())
lst_A = list(map(int,input().split()))
lst_B = list(map(int,input().split()))
ans = 0
while lst_A :
    a = min(lst_A)
    b = max(lst_B)
    ans += a*b
    lst_A.remove(a)
    lst_B.remove(b)

print(ans)