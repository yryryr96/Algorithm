# 30의 배수이면 각 자리수의 합이 3의 배수이다.
import sys
input = sys.stdin.readline

numbers = input().rstrip()
num = list(map(int,numbers))

temp = 1

if '0' not in numbers :
    temp = 0

if temp == 0 :
    print(-1)
else :
    if sum(num) % 3 == 0 :
        num.sort(key=lambda x : -x)
        num = list(map(str,num))
        print(''.join(num))
    else:
        print(-1)
