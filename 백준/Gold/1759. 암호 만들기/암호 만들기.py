import sys
input = sys.stdin.readline

L,C = map(int,input().split())
check = ['a','e','i','o','u']
alpha = list(input().split())
alpha.sort()
ans = []
def dfs(idx,word):
    if len(word) == L :
        cnt = 0
        temp = 0
        for k in check :
            if k in set(word) :
                cnt += 1
                temp = 1
        if temp == 1 and len(word) - cnt >= 2 :
            if word not in ans :
                ans.append(word)
        return

    for i in range(idx+1,C):
        dfs(i,word+alpha[i])
    return

for i in range(C):
    dfs(i,alpha[i])

ans.sort()

for word in ans :
    print(word)

