import sys
input = sys.stdin.readline

N = int(input())
cnt = 0
List = list(map(int,input().split()))
v = int(input())
for n in List :
    if n == v :
        cnt += 1

print(cnt)