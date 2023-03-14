import sys
from collections import deque
input = sys.stdin.readline

string = input().split('-')
lst = list(string)

for i in range(len(string)):
    ans = 0
    temp = ''
    for j in range(len(lst[i])):
        if lst[i][j].isdigit() :
            temp += lst[i][j]
        else :
            ans += int(temp)
            temp = ''
    if temp :
        ans+=int(temp)

    lst[i] = ans

ans = lst[0]
for i in range(1,len(lst)):
    ans -= lst[i]

print(ans)