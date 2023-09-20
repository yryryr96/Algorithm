n = int(input())
lst = list(map(int,input().split()))
cnt = 0
ans = 0
for a in lst :
    if a != 0 :
        cnt += 1
    else :
        cnt = 0
    ans = max(cnt,ans)
print(ans)