A,B = input().split()
A = list(A)
B = list(B)

MINA = ''
MAXA = ''
MINB = ''
MAXB = ''

for i in range(len(A)):
    if A[i] == '5' or A[i] == '6':
        MAXA += '6'
        MINA += '5'
    else :
        MAXA += A[i]
        MINA += A[i]

for i in range(len(B)):
    if B[i] == '5' or B[i] == '6':
        MAXB += '6'
        MINB += '5'
    else :
        MAXB += B[i]
        MINB += B[i]

print(int(MINA)+int(MINB), int(MAXA)+int(MAXB))
