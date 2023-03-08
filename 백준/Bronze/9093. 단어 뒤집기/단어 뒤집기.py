import sys
input = sys.stdin.readline
T = int(input())

for tc in range(1,T+1):
    n = list(map(str,input().split()))
    for i in range(len(n)):

        print(''.join(reversed(n[i])),end = ' ')
    print()