T = int(input())
for i in range(T):
    r,S = map(str,input().split())
    R = int(r)

    for i in S :
        for j in range(R):
            print(i,end='')
    print()