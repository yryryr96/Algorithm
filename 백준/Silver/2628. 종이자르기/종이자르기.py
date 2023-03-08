import sys
input = sys.stdin.readline

N,M = map(int,input().split())
K = int(input())

graph = [[1 for _ in range(N+1)] for _ in range(M+1)]
lst_r = [M]
lst_c = [N]
for _ in range(K):
    a,b = map(int,input().split())

    if a == 0 :
        lst_r.append(b)
    else :
        lst_c.append(b)

lst_r.sort()
lst_c.sort()
lst1 = [lst_r[0]]
lst2 = [lst_c[0]]
ans = []
for i in range(1,len(lst_r)):
    lst1.append(lst_r[i] - lst_r[i-1])

for i in range(1,len(lst_c)):
    lst2.append(lst_c[i] - lst_c[i-1])

for i in range(len(lst1)):
    for j in range(len(lst2)):
        ans.append(lst1[i]*lst2[j])

print(max(ans))

