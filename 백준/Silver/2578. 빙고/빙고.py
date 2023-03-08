import sys
input = sys.stdin.readline

bingo1 = [list(map(int,input().split())) for _ in range(5)]

ano = [list(map(int,input().split())) for _ in range(5)]
temp = 0
def search():
    global cnt,temp
    bingo2 = list(map(list,zip(*bingo1)))
    for i in range(5):
        if sum(bingo1[i]) == 0:
            cnt += 1

    for j in range(5):
        if sum(bingo2[j]) == 0:
            cnt += 1
    SUM1 = 0
    SUM2 = 0
    for k in range(5):
        SUM1 += bingo1[k][k]
        SUM2 += bingo1[k][4-k]

    if SUM1 == 0 :
        cnt += 1
    if SUM2 == 0 :
        cnt += 1

    if cnt >= 3:
        temp = 1
        return
ans = []
COUNT = 0
for i in range(5):
    for j in range(5):
        v = ano[i][j]
        for k in range(5):
            for n in range(5):
                if bingo1[k][n] == v:
                    cnt = 0
                    COUNT += 1
                    bingo1[k][n] = 0
                    search()
                    if temp == 1:
                        ans.append((v,COUNT))
                        break

print(ans[0][1])


