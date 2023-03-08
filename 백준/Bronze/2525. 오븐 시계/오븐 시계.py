A,B=map(int,input().split())
C=int(input())

if (B+C)/60 < 1 :
    print(A,B+C)

elif (B+C)/60 >= 1 :
    A=A+int((B+C)/60)
    B=(B+C)%60

    if A > 23:
        A=A-24
    print(A,B)