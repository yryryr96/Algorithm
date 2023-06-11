import sys
input = sys.stdin.readline

n = int(input())
lst = []
title = []
for _ in range(n):
    a = input().rstrip().split()
    if a[1] not in title :
        title.append(a[1])

    a = a[1:]
    lst.append(a)

title.sort()
lst.sort()
for t in title :
    print(t)
    for i in range(len(lst)) :
        if lst[i][0] == t :
            idx = 1
            if i == 0 :
                for k in range(idx, len(lst[i])):
                    print('--' * k + lst[i][k])
                continue
            for j in range(len(lst[i])) :
                if len(lst[i-1]) <= j or lst[i][j] != lst[i-1][j] :
                    break
                else :
                    idx = j + 1

            for k in range(idx, len(lst[i])) :
                print('--'*k + lst[i][k])