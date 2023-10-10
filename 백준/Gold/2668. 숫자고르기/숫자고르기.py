import sys
input = sys.stdin.readline

n = int(input())
bottom = [0]

for _ in range(n):
    bottom.append(int(input()))

def dfs(i) :

    if visited[i] == 0 :
        visited[i] = 1
        t.add(i)
        b.add(bottom[i])
        dfs(bottom[i])

ans = []
visited = [0]*(n+1)

for i in range(1,n+1):
    t = set()
    b = set()
    dfs(i)

    if t == b :
        for num in b :
            ans.append(num)

    else :
        for num in b :
            visited[num] = 0

ans = list(set(ans))
print(len(ans))
for num in sorted(ans) :
    print(num)