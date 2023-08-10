import sys
input = sys.stdin.readline

N,R = map(int,input().split())
cities = list(input().rstrip().split())

M = int(input())
trip = list(input().rstrip().split())

K = int(input())

INF = sys.maxsize
sale = [[INF]*N for _ in range(N)]
nonSale = [[INF]*N for _ in range(N)]

for _ in range(K):
    info = list(input().rstrip().split())
    price = int(info[-1])
    a = cities.index(info[1])
    b = cities.index(info[2])

    nonSale[a][b] = min(nonSale[a][b],price)
    nonSale[b][a] = min(nonSale[b][a],price)

    if info[0] in ['ITX-Saemaeul', 'ITX-Cheongchun','Mugunghwa'] :
        sale[a][b] = sale[b][a] = 0
    elif info[0] in ['S-Train','V-Train'] :
        sale[a][b] = min(sale[a][b],price/2)
        sale[b][a] = min(sale[b][a],price/2)
    else :
        sale[a][b] = min(sale[a][b],price)
        sale[b][a] = min(sale[b][a],price)

def minPrice(lst) :

    for k in range(N):
        for i in range(N):
            for j in range(N):
                if i==j : continue
                lst[i][j] = min(lst[i][k] + lst[k][j], lst[i][j])

minPrice(nonSale)
minPrice(sale)

sale_price = 0
nonSale_price = 0
for i in range(M-1):
    a = cities.index(trip[i])
    b = cities.index(trip[i+1])
    sale_price += sale[a][b]
    nonSale_price += nonSale[a][b]

if sale_price + R < nonSale_price : print("Yes")
else : print("No")

