import sys
input = sys.stdin.readline

N = int(input())
List = []
for i in range(N):
    a = int(input())
    List.append(a)

List = sorted(List)

for i in range(len(List)):
    print(List[i])