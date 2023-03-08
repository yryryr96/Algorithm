T = int(input())
cnt = 0
scores=[]
for _ in range(T):
    n = list(input())

    for i in range(len(n)) :
        if n[i] == 'O' :
            cnt += 1
            scores.append(cnt)
        elif n[i] == 'X' :
            cnt = 0
            scores.append(cnt)
    cnt = 0
    print(sum(scores))
    scores.clear()


