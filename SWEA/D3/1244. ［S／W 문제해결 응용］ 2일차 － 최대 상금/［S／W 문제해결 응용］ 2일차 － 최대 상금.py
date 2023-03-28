T = int(input())

for tc in range(1,T+1):
    number, n = input().split()
    n = int(n)
    number = list(number)
    numbers = sorted(number,key=lambda x:-int(x[0]))
    numbers = int(''.join(numbers))
    check = []
    MAX = 0
    a = 0
    def dfs(number, cnt):
        global MAX, a
        a+=1
        if a >= 10**6 :
            return

        if MAX == numbers :
            return

        if cnt == n:
            if MAX < int(''.join(number)):
                MAX = int(''.join(number))
            return


        for i in range(len(number) - 1):
            for j in range(i + 1, len(number)):
                number[i], number[j] = number[j], number[i]
                dfs(number, cnt + 1)
                number[i], number[j] = number[j], number[i]
        return

    if len(number) == 2:
        for _ in range(n):
            number[0], number[1] = number[1], number[0]
        print(f"#{tc} {''.join(number)}")
    else:
        dfs(number, 0)
        print(f"#{tc} {MAX}")

