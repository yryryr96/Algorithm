import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    lst = []
    for _ in range(n):
        lst.append(input().rstrip())
    lst.sort(key=len)
    temp = 0
    for i in range(len(lst)-1):
        for j in range(i+1,len(lst)) :
            if lst[i][0] == lst[j][0] :
                if lst[j][:len(lst[i])] == lst[i] :
                    temp = 1
                    break
    if temp == 1:
        print("NO")
    else:
        print("YES")
