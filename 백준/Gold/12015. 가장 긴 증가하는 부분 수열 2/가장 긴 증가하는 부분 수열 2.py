import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
lis = []
def find(x):
    start = 0
    end = len(lis)-1
    while start <= end :
        mid = (start + end) // 2
        if lis[mid] == x :
            return mid
        elif lis[mid] < x :
            start = mid + 1

        elif lis[mid] > x :
            end = mid - 1

    return start

for i in lst :
    if not lis or lis[-1] < i :
        lis.append(i)
    else:
        idx = find(i)
        lis[idx] = i

print(len(lis))