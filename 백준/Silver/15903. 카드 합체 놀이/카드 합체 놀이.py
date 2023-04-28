import sys, heapq
input = sys.stdin.readline

n,m = map(int,input().split())
q = []
lst = list(map(int,input().split()))
for num in lst :
    heapq.heappush(q,num)

for _ in range(m):
    p = heapq.heappop(q) + heapq.heappop(q)
    heapq.heappush(q,p)
    heapq.heappush(q,p)

print(sum(q))