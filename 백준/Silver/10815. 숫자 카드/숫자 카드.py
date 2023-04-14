import sys
input = sys.stdin.readline

n = int(input())
lst1 = set(map(int,input().split()))
m = int(input())
lst2 = list(map(int,input().split()))

for i in lst2 :
    if i in lst1 :
        print(1,end = " ")
    else :
        print(0,end = " ")
        