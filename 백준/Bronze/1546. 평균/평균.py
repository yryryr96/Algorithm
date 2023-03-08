import sys
input = sys.stdin.readline

N = int(input())
scores = list(map(int,input().split()))
M = max(scores)
new_scores = []
SUM = 0

for score in scores :
    score = score/M*100
    new_scores.append(score)

for score in new_scores :
    SUM += score

print(SUM/len(new_scores))