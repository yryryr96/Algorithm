import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    lst = []
    for _ in range(n):
        lst.append(input().rstrip())
    lst.sort()

    for i in range(len(lst)-1):
        if lst[i+1].startswith(lst[i]) :
            print("NO")
            break
    else:
        print("YES")



