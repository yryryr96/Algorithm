K,N = map(int,input().split())
lst = []
for _ in range(K):
    n = int(input())
    lst.append(n)
end = max(lst)
start = 1
middle = (start + end) // 2

while start <= end:

    middle = (start + end) // 2
    SUM = 0

    for k in lst:
        SUM += k//middle

    if SUM < N:
        end = middle -1

    if SUM >= N:
        start = middle + 1

print(end)

