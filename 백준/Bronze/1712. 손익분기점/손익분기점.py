import math
import sys
input = sys.stdin.readline

A,B,C = map(int,input().split())

if C!=B :

    BEP = int(A/(C-B) +1)
    if BEP <= 0:
        print(-1)
    else :
        print(BEP)

else :
    print(-1)