lst = []
for _ in range(9):
    n = int(input())
    lst.append(n)
ans = []
SUM = sum(lst)
ANS = SUM - 100
for i in range(8):
    for j in range(i+1,9):
        if lst[i]+lst[j] == ANS :
            ans.append((i,j))

a = lst[ans[0][0]]
b = lst[ans[0][1]]
lst.remove(a)
lst.remove(b)
lst.sort()

for i in range(len(lst)):
    print(lst[i])
