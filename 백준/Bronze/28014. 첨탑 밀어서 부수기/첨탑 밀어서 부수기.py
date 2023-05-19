n = int(input())
lst = list(map(int,input().split()))
ans = 1
for i in range(n-1) :
    if lst[i] <= lst[i+1] :
        ans += 1
print(ans)