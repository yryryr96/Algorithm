import sys
input = sys.stdin.readline

n = int(input())
lst = []
for _ in range(n):
    a = int(input())
    lst.append(a)

lst.sort(key=lambda x:-x)


MAX = 0
while lst :
    ans = lst[-1]*len(lst)
    if ans > MAX :
        MAX = ans

    lst.pop()

print(MAX)
