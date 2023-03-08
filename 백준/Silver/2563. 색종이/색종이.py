T = int(input())
List = [[0 for _ in range(100)] for _ in range(100)]
for tc in range(1,1+T) :
    x,y = map(int,input().split())

    for i in range(10) :
        for j in range(10) :
            List[y+i][x+j] = 1

cnt = 0
for i in range(100):
    for j in range(100):
        if List[i][j] == 1 :
            cnt += 1

print(cnt)

