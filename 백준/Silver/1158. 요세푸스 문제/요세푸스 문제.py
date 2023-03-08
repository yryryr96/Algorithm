import sys
input = sys.stdin.readline
N,K = map(int,input().split())
lst = []
ans = []
for i in range(1,N+1):
    lst.append(i)
i = K - 1
while lst:
    if i >= len(lst):
        while i >= len(lst):
            i = i - len(lst)
    ans.append(lst.pop(i))
    i = i + (K - 1)

lst1 = list(map(str,ans))
print(f'<{", ".join(lst1)}>')


