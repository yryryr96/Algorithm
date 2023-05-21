import sys
from collections import defaultdict
input = sys.stdin.readline

n,m = map(int,input().split())
dic = defaultdict()
ans = []

for _ in range(n):
    a = input().rstrip()
    dic[a] = 0
    ans.append(a)

for _ in range(m):
    b = input().rstrip()
    dic[b] = 0
    ans.append(b)

for name in ans :
    dic[name] += 1

check = []
for key,value in dic.items() :
    if value == 2 :
        check.append(key)
check.sort()
print(len(check))
for name in check :
    print(name)
