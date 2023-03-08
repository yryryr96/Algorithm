number = int(input())
ans = number
cnt = 0
while True :
    if number >= 10 :
        a = int(str(number)[0]) + int(str(number)[1])

    elif number < 10 :
        a = number

    if a >= 10 :
        k = a-10


    elif a < 10 :
        k = a

    if number >= 10 :
        number = int(str(number)[1] + str(k))

        cnt += 1

    elif number < 10 :
        number = int(str(number)[0] + str(k))

        cnt += 1

    if number == ans :
        print(cnt)
        break