import sys

List = []
N = int(sys.stdin.readline().strip())

for i in range(N):
    a = sys.stdin.readline()

    if 'push' in a:
        y = int(a[5:])
        List.append(y)

    elif 'pop' in a:
        if len(List) == 0:
            print(-1)
        else:
            print(List.pop())

    elif 'size' in a:
        print(len(List))

    elif 'empty' in a:
        if len(List) == 0:
            print(1)
        else:
            print(0)

    elif 'top' in a:
        if len(List) == 0:
            print(-1)
        else:
            print(List[-1])
