from collections import deque
visited = [0]*100001
N,K = map(int,input().split())
ans_way = 0
ans_count = 0
def bfs(v,K):
    global ans_way,ans_count
    q = deque()
    q.append(v)
    visited[v] = 1
    ans_way = 0
    ans_count = 0
    
    while q :
        now = q.popleft()

        if now == K :
            ans_way += 1
            ans_count = visited[now] - 1

        for after in [now-1,now+1,now*2]:
            if 0<= after <= 100000 and (visited[after] == 0 or visited[after] == visited[now] + 1) :
                visited[after] = visited[now] + 1
                q.append(after)
bfs(N,K)
print(ans_count)
print(ans_way)

