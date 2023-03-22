import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
numbers = sorted(set(lst))
check = {}

for i in range(len(numbers)):
    check[numbers[i]] = i

for i in lst:
    print(check[i],end = ' ')
