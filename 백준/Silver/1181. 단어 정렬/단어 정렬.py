N = int(input())
List = []
ANS = []
for i in range(N):
    word = input()
    List.append(word)
List.sort()
lst = list(set(List))
lst.sort()
lst.sort(key=len)

for i in range(len(lst)):
    print(lst[i])


