import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))

visited = [0]*(max(lst)+1)
for i in lst :
    visited[i] += 1
st = []
ans = [0]*(n)

for i in range(n):
    while st and visited[lst[st[-1]]] < visited[lst[i]] :
        ans[st.pop()] = lst[i]
    st.append(i)

for num in st :
    ans[num] = -1

print(*ans)