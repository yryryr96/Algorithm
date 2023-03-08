

while True :
    n = input()

    if n == n[::-1] :
        if n == '0' :
            break
        print('yes')

    elif n != n[::-1] :
        print('no')



