import sys
input = sys.stdin.readline

n = int(input())
lst = []
for _ in range(n):
    a,b = map(int,input().split())
    lst.append((a,b))

lst.sort(key = lambda x:(x[1],x[0]))
cnt = 1
temp = lst[0][1]

for i in range(1,n):
    if lst[i][0] >= temp :
        temp = lst[i][1]
        cnt += 1

print(cnt)
