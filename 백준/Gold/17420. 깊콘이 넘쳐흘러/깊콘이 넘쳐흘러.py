import sys,math
input = sys.stdin.readline

n = int(input())

A = list(map(int,input().split()))
B = list(map(int,input().split()))
lst = []

for i in range(n):
    lst.append([A[i],B[i]])
lst.sort(key = lambda x: (x[1],x[0]))

ans = 0
MAX = 0
temp = lst[0][1]
for i in range(n):

    if lst[i][0] < temp :
        temp = max(temp,lst[i][1])
        k = math.ceil((temp-lst[i][0])/30)
        lst[i][0] += k*30
        ans += k

    MAX = max(MAX,lst[i][0])
    if i+1 < n and lst[i+1][1] != lst[i][1] :
        temp = MAX

print(ans)
