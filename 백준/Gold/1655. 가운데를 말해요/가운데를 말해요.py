import sys, heapq
input = sys.stdin.readline

n = int(input())
max_heap = []
min_heap = []

for i in range(1,n+1):
    a = int(input())
    if len(max_heap) == len(min_heap) :
        heapq.heappush(max_heap,-a)

    else :
        heapq.heappush(min_heap,a)

    if not min_heap :
        print(-max_heap[0])
    else:
        if -max_heap[0] > min_heap[0] :
            A,B = -heapq.heappop(max_heap), heapq.heappop(min_heap)
            heapq.heappush(max_heap,-B)
            heapq.heappush(min_heap,A)
        print(-max_heap[0])
