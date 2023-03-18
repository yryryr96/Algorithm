import sys,heapq
input = sys.stdin.readline

n,m = map(int,input().split())
q = list(map(int,input().split()))
q.sort(reverse=True)
ans = []

for i in q :
    if len(ans) < m :
        heapq.heappush(ans,i)
    else :
        k = heapq.heappop(ans)
        heapq.heappush(ans,k+i)
print(max(ans))