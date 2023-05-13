import sys
input = sys.stdin.readline
lst = [0]*10001
n = int(input())
for _ in range(n):
    a = int(input())
    lst[a] += 1

for i in range(10001):
    for _ in range(lst[i]) :
        print(i)
