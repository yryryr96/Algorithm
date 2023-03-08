C = int(input())
socres = []
total_score = 0
avg = 0
cnt = 0
for _ in range(C):
    n = list(map(int,input().split()))
    N = n[0]
    for i in range(N) :
       total_score += n[i+1]

    avg = total_score / N

    for k in range(N) :
        if n[k+1] > avg :
            cnt += 1
    print("{:.3f}%".format(cnt/N*100))

    total_score = 0 ; cnt = 0; avg = 0 ;