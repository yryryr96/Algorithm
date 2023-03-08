M = int(input())
N = int(input())
List = []
cnt = 0
if M == 1 :
    M = 2
    
for num in range(M,N+1):

    for k in range(2,num):
        if num % k == 0 :
            cnt += 1

    if cnt == 0 :
        List.append(num)
    cnt = 0

if List == [] :
    print(-1)
else:

    print(sum(List))
    print(min(List))
