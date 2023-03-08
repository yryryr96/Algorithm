for _ in range(4):
    x1,y1,p1,q1,x2,y2,p2,q2 = map(int,input().split())
    temp = 1
    if x2>p1 or y2>q1 or x1>p2 or y1 > q2 :
        temp = 4

    elif q1 == y2 or q2 == y1 :
        if p1==x2 or p2==x1 :
            temp = 3
        else:
            temp = 2
    elif p1 == x2 or p2 == x1 :
        temp = 2
    else:
        temp = 1

    if temp == 1 :
        print('a')
    elif temp == 2:
        print('b')
    elif temp == 3:
        print('c')
    elif temp == 4:
        print('d')
