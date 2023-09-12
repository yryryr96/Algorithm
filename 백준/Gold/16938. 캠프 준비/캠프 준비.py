import sys
input = sys.stdin.readline

n,l,r,x = map(int,input().split())

# 난이도 합 l ~ r
# 가장 어려운 난이도 - 가장 쉬운 난이도 >= x
score = list(map(int,input().split()))
score.sort()

ans = 0
def dfs(v, ss):
    global ans

    if ss and l <= sum(ss) <= r and ss[-1] - ss[0] >= x :
        ans += 1

    if sum(ss) > r : return

    for i in range(v+1,n) :
        ss.append(score[i])
        dfs(i,ss)
        ss.pop()

for i in range(n):
    dfs(i,[score[i]])

print(ans)