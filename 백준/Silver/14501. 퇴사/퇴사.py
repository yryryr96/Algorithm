import sys
input = sys.stdin.readline

n=int(input())
lst = []
ans = 0
lst.append((0,0))
for _ in range(n):
    a,b = map(int,input().split())
    lst.append((a,b))

MAX = 0
def dfs(day,money):
    global MAX
    check = day + lst[day][0]
    if check-1 > n :
        return

    if money > MAX :
        MAX = money

    
    for i in range(check,n+1):
        dfs(i,money+lst[i][1])

for i in range(1,n+1):
    dfs(i,lst[i][1])
print(MAX)


