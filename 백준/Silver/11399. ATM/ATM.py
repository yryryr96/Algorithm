import sys

input = sys.stdin.readline
N = int(input())
List = list(map(int,input().split()))
a = sorted(List)
SUM = 0
numbers = []
for i in a :
    SUM += i
    numbers.append(SUM)

print(sum(numbers))