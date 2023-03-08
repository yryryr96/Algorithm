S = input()
List = []
for i in range(97,123):
    List.append(S.find(chr(i)))

for n in List :
    print(n,end = ' ')
