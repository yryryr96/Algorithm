import sys
input = sys.stdin.readline
score = []
N = int(input())
k = N//5
n = N//3
for i in range(0,k+1) :
    for j in range(0,n+1):
        if N == 5*i + 3*j :
            score.append(i+j)

if len(score) == 0:
    print(-1)

else :
    print(min(score))