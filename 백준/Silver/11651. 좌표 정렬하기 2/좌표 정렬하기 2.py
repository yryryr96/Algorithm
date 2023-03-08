import sys
input = sys.stdin.readline
N = int(input())
ANS = []
for i in range(N):
    x,y = map(int,input().split())
    ANS.append([y,x])

ANS.sort()

for i in range(N):
    print(ANS[i][1],ANS[i][0])







