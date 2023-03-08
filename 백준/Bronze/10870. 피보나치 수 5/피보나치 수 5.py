import sys
input = sys.stdin.readline

def piv(n):
    if n == 1:
        return 1
    elif n == 0 :
        return 0

    return piv(n-1) + piv(n-2)
n = int(input())
print(piv(n))