import sys,heapq
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    k = int(input())
    max_heap = []
    min_heap = []
    visited = [0]*k
    for id in range(k):
        command,num = input().rstrip().split()
        num = int(num)

        if command == 'I' :
            heapq.heappush(max_heap,(-num,id))
            heapq.heappush(min_heap,(num,id))
            visited[id] = 1

        else:
            if num == - 1:
                while min_heap and not visited[min_heap[0][1]] :
                    heapq.heappop(min_heap)
                if min_heap :
                    visited[min_heap[0][1]] = 0
                    heapq.heappop(min_heap)

            elif num == 1 :
                while max_heap and not visited[max_heap[0][1]] :
                    heapq.heappop(max_heap)
                if max_heap :
                    visited[max_heap[0][1]] = 0
                    heapq.heappop(max_heap)

    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)

    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)

    if not min_heap or not max_heap :
        print('EMPTY')
    else:
        print(-max_heap[0][0],min_heap[0][0])