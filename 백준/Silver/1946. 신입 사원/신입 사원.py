import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    lst = []
    for _ in range(n):
        a,b = map(int,input().split())
        lst.append((a,b))
    lst.sort(key=lambda x:(x[0]))
    check = {}
    for i,j in lst :
        check[i] = j

    MIN = check[1]
    cnt = 1
    for i in range(2,len(check)+1):
        if check[i] < MIN :
            MIN = check[i]
            cnt += 1
    
    print(cnt)
