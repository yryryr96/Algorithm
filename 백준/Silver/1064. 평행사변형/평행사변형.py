# a,b=map(int,input().split())
# a,b,c=map(int,input().split())
# 대문자 아스키 65~90
# 소문자 아스키 97~122
# List=[[_ for _ in range(5)] for _ in range(3)] >> 3*5 행렬 선언
# List=[i**3 for i in range()] >> i^3 을 리스트값으로 추가하며 리스트 선언

import math

Xa, Ya, Xb, Yb, Xc, Yc = map(float,input().split())

if Xa-Xb != 0 and Xc-Xb !=0 :

    if (Ya-Yb) / (Xa-Xb) == (Yc-Yb) / (Xc-Xb) :
        print(-1.0)

    else :
        AB_d = math.sqrt((Xa-Xb)**2 + (Ya-Yb)**2)
        BC_d = math.sqrt((Xb-Xc)**2 +(Yb-Yc)**2)
        CA_d = math.sqrt((Xc-Xa)**2 + (Yc-Ya)**2)

        a = AB_d + BC_d
        b = BC_d + CA_d
        c = CA_d + AB_d

        List = [a,b,c]
        MAX = 0
        MIN = List[0]

        for d in List :
            if d > MAX :
                MAX = d


        for d in List :
            if MIN > d :
                MIN = d

        print((MAX-MIN)*2)

elif Xa - Xb == 0 and Xc - Xb == 0:
    print(-1.0)

else :
    AB_d = math.sqrt((Xa - Xb) ** 2 + (Ya - Yb) ** 2)
    BC_d = math.sqrt((Xb - Xc) ** 2 + (Yb - Yc) ** 2)
    CA_d = math.sqrt((Xc - Xa) ** 2 + (Yc - Ya) ** 2)

    a = AB_d + BC_d
    b = BC_d + CA_d
    c = CA_d + AB_d

    List = [a, b, c]
    MAX = 0
    MIN = List[0]

    for d in List:
        if d > MAX:
            MAX = d

    for d in List:
        if MIN > d:
            MIN = d

    print((MAX - MIN) * 2)


