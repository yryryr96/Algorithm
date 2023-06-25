import sys
input = sys.stdin.readline

# BN i j : 고유번호 i를 가진 역 다음 역의 고유번호 출력, 그 사이에 고유번호 j 인 역 설립
# BP i j : 고유번호 i를 가진 역 이전 역의 고유번호 출력, 그 사이에 고유번호 j 인 역 설립
# CN i j : 고유번호 i를 가진 역 다음 역을 폐쇄, 그 역의 고유번호 출력
# CP i j : 고유번호 i를 가진 역 이전 역을 폐쇄, 그 역의 고유번호 출력

N,M = map(int,input().split())
PREV = [0]*1000001
NEXT = [0]*1000001
lst = list(map(int,input().split()))
for i in range(N) :
    k = lst[i]
    if i == 0 :
        PREV[k] = lst[-1]
        NEXT[k] = lst[1]

    elif i == N-1 :
        PREV[k] = lst[i-1]
        NEXT[k] = lst[0]

    else :
        PREV[k] = lst[i-1]
        NEXT[k] = lst[i+1]

for _ in range(M):
    command = list(input().rstrip().split())
    com = command[0]
    if com == 'BN' or com == 'BP' :
        i,j = int(command[1]), int(command[2])

        if com == 'BN' :
            a = NEXT[i]
            print(a)
            PREV[a] = j
            NEXT[j] = a
            PREV[j] = i
            NEXT[i] = j

        elif com == 'BP' :
            a = PREV[i]
            print(a)
            NEXT[a] = j
            PREV[j] = a
            NEXT[j] = i
            PREV[i] = j

    else :
        i = int(command[1])
        if com == 'CN' :
            a = NEXT[i]
            print(a)
            NEXT[i] = NEXT[a]
            PREV[NEXT[a]] = i
            PREV[a] = NEXT[a] = 0

        elif com == 'CP' :
            a = PREV[i]
            print(a)
            PREV[i] = PREV[a]
            NEXT[PREV[a]] = i
            NEXT[a] = PREV[a] = 0