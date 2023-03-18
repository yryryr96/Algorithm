import sys, heapq
input = sys.stdin.readline

n = int(input())
q = []
for _ in range(n):
    num = int(input())
    heapq.heappush(q,num)

ans = 0
if len(q) == 1 :
    ans = 0
elif len(q) == 2:
    ans = q[0] + q[1]
else:
    while True :
        k = heapq.heappop(q) + heapq.heappop(q)
        ans += k
        if not q :
            break
        heapq.heappush(q,k)

print(ans)

# 시간초과
# ans = 0
# q.sort()
# while True:
#     k = (q.pop(0) + q.pop(0))
#     ans += k
#     if not q :
#         break
#     q.append(k)
#     q.sort()
#
#
# print(ans)
