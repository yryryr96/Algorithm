import sys
input = sys.stdin.readline

List = []

for _ in range(9) :
    a = int(input())
    List.append(a)


k = max(List)
print(k)
print(List.index(k) + 1)