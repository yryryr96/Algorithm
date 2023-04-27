import sys
input = sys.stdin.readline

n = int(input())
lst =set(map(int,input().split()))
m = int(input())
check = list(map(int,input().split()))
for num in check :
    if num in lst :
        print(1)
    else :
        print(0)