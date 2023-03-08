def fact(n):
    if n == 0 or n== 1 :
        return 1

    else :
        return n*fact(n-1)

n = int(input())
ans = fact(n)
ans = str(ans)
cnt = 0 ; i = -1
while ans[i] == '0' :
    cnt += 1
    i -= 1
print(cnt)
