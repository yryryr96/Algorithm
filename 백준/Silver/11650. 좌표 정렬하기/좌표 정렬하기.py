import sys
input = sys.stdin.readline

N = int(input())
POINT=[]
NEW_POINT=[]
for i in range(N):
    point= list(map(int,input().split()))
    POINT.append(point)

NEW_POINT = sorted(POINT)

for i in range(N):
    print(*NEW_POINT[i])