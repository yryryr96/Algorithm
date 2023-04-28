import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
lst.sort()
m = int(input())

start = 0
end = max(lst)
if sum(lst) <= m :
    print(end)

else :
    while start<=end :
        SUM = 0
        mid = (start+end) // 2
        for num in lst :
            if mid >= num :
                SUM += num
            else :
                SUM += mid

        if SUM > m :
            end = mid - 1

        else :
            ans = mid
            start = mid + 1
    print(ans)