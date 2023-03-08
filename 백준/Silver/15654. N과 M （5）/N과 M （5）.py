N,M = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()
ans = []
def back():
    if len(ans) == M :
        print(*ans)
        return

    for i in lst:
        if i not in ans:
            ans.append(i)
            back()
            ans.pop()

back()