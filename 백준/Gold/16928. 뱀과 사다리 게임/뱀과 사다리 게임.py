import sys
from collections import deque , defaultdict
input = sys.stdin.readline

n,m = map(int,input().split())
dic = defaultdict()

for _ in range(n):
    a,b = map(int,input().split())
    dic[a] = b

for _ in range(m):
    a,b = map(int,input().split())
    dic[a] = b

visited = [0]*101
q = deque()
q.append(1)

while q:
    now = q.popleft()
    if now == 100 :
        print(visited[100])
        break
    if dic.get(now,0) != 0 :
        visited[dic[now]] = visited[now]
        now = dic[now]

    for i in [now+1,now+2,now+3,now+4,now+5,now+6] :
        if i <= 100 and visited[i] == 0 :
            visited[i] = visited[now] + 1
            q.append(i)
