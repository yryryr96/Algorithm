import sys,heapq
input = sys.stdin.readline

n = int(input())
q = []

for _ in range(n):
    num = int(input())
    if num == 0 :
        if not q :
            print(0)
        else :
            a,b = heapq.heappop(q)
            print(b)
    else :
        heapq.heappush(q, (abs(num),num))
    
