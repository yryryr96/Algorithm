while True :
    a,b,c = map(int,input().split())
    if a == 0 and b == 0 and c == 0 :
        break
    
    lst = []
    C = max(a,b,c)
    for i in [a,b,c] :
        if i != C :
            lst.append(i)
    
    if lst[0]**2 + lst[1]** 2 == C**2 : print("right")
    else : print('wrong')