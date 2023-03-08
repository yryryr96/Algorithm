import sys
input = sys.stdin.readline

N = int(input())
List = list(map(int,input().split()))
print(min(List),max(List))