import sys
from collections import deque
input = sys.stdin.readline

N,M,T = map(int,input().split())

zero = deque()
one = deque()

for num in range(N):
    d,m,r = map(int,input().split())
    if d == 0 :
        zero.append([num,m,r])
    else :
        one.append([num,m,r])

cd = 0
ct = 0
ans = [[] for _ in range(N)]
while (zero or one) :
    # print(cd,ct)
    # print(zero)
    # print(one)
    w = 0
    if cd == 0 :
        if zero :
            # print(zero)
            if one and ct < zero[0][2] and one[0][2] < zero[0][2] :
                if ct < one[0][2] :
                    ct = one[0][2] + T
                    cd = 1

                else :
                    ct += T
                    cd = 1

                continue

            if zero[0][2] > ct :
                # print(zero,one,ct)
                ct = zero[0][2]
                continue

            while zero and zero[0][2] <= ct and w < M:
                number,a,b = zero.popleft()
                if w + a <= M :
                    w += a
                    ans[number].append(ct)
                    ans[number].append(ct+T)
                else :
                    # w = M
                    # print(w+a-M)
                    zero.appendleft([number,w+a-M,b])
                    ans[number].append(ct)
                    break
            ct += T
            cd = 1

        else :
            ct += T
            cd = 1

    else :
        if one :
            if zero and ct < one[0][2] and zero[0][2] < one[0][2] :
                if ct < zero[0][2]:
                    ct = zero[0][2] + T
                    cd = 0

                else:
                    ct += T
                    cd = 0
                continue

            if one[0][2] > ct :
                # print(zero,one,ct)
                ct = one[0][2]
                continue

            while one and one[0][2] <= ct and w < M :
                number,a,b = one.popleft()
                if w + a <= M :
                    w += a
                    ans[number].append(ct)
                    ans[number].append(ct + T)

                else :
                    # w = M
                    one.appendleft([number,w+a-M,b])
                    ans[number].append(ct)
                    break

            cd = 0
            ct += T
        else :
            ct += T
            cd = 0

for lst in ans :
    print(lst[0],lst[-1])