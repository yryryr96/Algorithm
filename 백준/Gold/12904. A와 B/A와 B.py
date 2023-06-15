import sys
input = sys.stdin.readline

S = input().rstrip()
T = list(input().rstrip())

# print(T)
words = [T]
while True :
    tmp = 0
    temp = []

    for word in words :
        # print(word)
        if len(word) == len(S) + 1 :
            tmp = 1
        if word[-1] == 'A' :
            temp.append(word[:-1])
        elif word[-1] == 'B' :
            word.pop()
            temp.append(list(reversed(word)))

    # print(temp)
    if tmp :
        for word in temp :
            if ''.join(word) == S :
                print(1)
                exit()
        else :
            print(0)
            break
    words = temp
