import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def lion(n):
    f = [0]*(n+1)
    f[0] = 1
    f[1] = 3

    for i in range(2,n+1):
        f[i] = (2*f[i-1] + f[i-2])%9901

    return f[n]

n = int(input())

print(lion(n))
