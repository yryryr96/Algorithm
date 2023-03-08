from itertools import permutations
import sys
input = sys.stdin.readline

N = int(input())
money = 1000 - N
ans = 0
lst = [500,100,50,10,5,1]

for i in range(len(lst)):
    ans += money//lst[i]
    money = money%lst[i]
print(ans)