S = input()
A = list(S)
a = list(reversed(A[2:4]))

i = 0; cnt = 0
while i <= len(S) - 1 :
    if A[i] == '<' :
        while A[i] != '>' :
            print(A[i],end='')
            i += 1

    elif A[i] == '>' :
        print(A[i],end='')
        i += 1

    elif A[i] == ' ' :
        print(' ',end='')
        i += 1

    else :
        cnt = i
        while A[i] != '<' :
            i += 1
            if i == len(A):
                break
            if A[i] == ' ' :
                break

        print(''.join(list(reversed(A[cnt : i]))),end='')

