T = int(input())

for i in range(T) :
    n = input()
    List = list(n)
    sum = 0

    for i in range(len(List)) :

        if List[i] == '(' :
            sum += 1
        elif List[i] == ')' :
            sum -= 1
        if sum < 0 :
            print("NO")
            break
    if sum > 0 :
        print("NO")
    elif sum == 0 :
        print("YES")