import sys
input = sys.stdin.readline

List = [_ for _ in range(1,31)]

for i in range(len(List)-2) :
    n = int(input())
    for j in List :
        if n == j:
            List.remove(n)

for i in range(len(List)):
    print(List[i])