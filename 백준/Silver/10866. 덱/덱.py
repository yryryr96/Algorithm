import sys
input = sys.stdin.readline

lst = []
T = int(input())
for tc in range(1,T+1):
    command = list(map(str,input().split()))

    if command[0] == 'push_back' :
        lst.append(int(command[1]))

    elif command[0] == 'push_front' :
        lst.insert(0,int(command[1]))

    elif command[0] == 'pop_front' :
        if not lst:
            print(-1)
        else:
            print(lst.pop(0))

    elif command[0] == 'pop_back' :
        if not lst :
            print(-1)
        else :
            print(lst.pop())

    elif command[0] == 'size' :
        print(len(lst))

    elif command[0] == 'empty' :
        if lst:
            print(0)
        else :
            print(1)

    elif command[0] == 'front' :
        if lst :
            print(lst[0])
        else :
            print(-1)

    elif command[0] == 'back' :
        if lst :
            print(lst[-1])
        else :
            print(-1)

