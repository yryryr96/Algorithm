import sys
input = sys.stdin.readline

A,B,C = map(int,input().split())

def multi(A,B):
    if B == 1 :
        return A%C

    temp = multi(A,B//2)

    if B%2 == 0 :
        return temp*temp%C

    else :
        return A*temp*temp%C

print(multi(A,B))