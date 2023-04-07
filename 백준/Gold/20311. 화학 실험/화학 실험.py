import sys
input = sys.stdin.readline

N, K = map(int, input().split())
color = list(map(int, input().split()))

if max(color) > (N+1)//2:
    print(-1)
    sys.exit()

tubes = [0] * N
idx = 0
for i in sorted(range(K), key=lambda x: -color[x]):
    for j in range(color[i]):
        tubes[idx] = i+1
        idx += 2
        if idx >= N:
            idx = 1

print(*tubes)
