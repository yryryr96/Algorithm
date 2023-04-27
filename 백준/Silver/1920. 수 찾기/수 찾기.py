import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
lst.sort()
m = int(input())
check = list(map(int,input().split()))
MAX = max(lst)
MIN = min(lst)
def binarySearch(v,lst):
    start = 0
    end = n - 1

    while start <= end :
        middle = (start + end) // 2
        if lst[middle] == v :
            return 1

        elif lst[middle] < v :
            start = middle + 1

        elif lst[middle] > v :
            end = middle - 1

    return 0

for num in check :
    if num > MAX :
        print(0)
        continue
    elif num < MIN :
        print(0)
        continue
    else:
        print(binarySearch(num,lst))