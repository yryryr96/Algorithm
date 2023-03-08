import sys
input = sys.stdin.readline
n = int(input())
lst = []
ans = []
cnt = 1
temp = True

for i in range(n):
    num = int(input())

    while cnt <= num :
        lst.append(cnt)
        ans.append('+')
        cnt += 1

    if lst[-1] == num :
        lst.pop()
        ans.append('-')

    else :
        temp = False
if temp == False :
    print('NO')
else:
    for i in ans:
        print(i)