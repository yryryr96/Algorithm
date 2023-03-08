
List = [['A','B','C'],['D','E','F'],['G','H','I'],['J','K','L'],['M','N','O'],['P','Q','R','S'],['T','U','V'],['W','X','Y','Z']]

n = input()
OUT = 0

for k in range(len(n)):

    for i in range(len(List)):

        for j in range(len(List[i])):

            if n[k] == List[i][j] :
                OUT += (i+2)

print(OUT+len(n))


