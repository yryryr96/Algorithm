import sys,heapq
input = sys.stdin.readline

N,M = map(int,input().split()) # N 학급, M 각 학급의 학생 수

MAX = 0
index_cnt = [0]*N # i행 팀의 몇번째 학생인지
team = []
q = []
for i in range(N):
    lst = sorted(list(map(int,input().split())))
    MAX = max(MAX,lst[0])
    heapq.heappush(q, (lst[0],i))
    team.append(lst)

ans = sys.maxsize
while q:
    now = heapq.heappop(q)
    min_value = now[0]
    min_idx = now[1]

    # print(min_value,now[1])
    ans = min(MAX - min_value, ans)

    index_cnt[min_idx] += 1
    if index_cnt[min_idx] == M :
        break

    MAX = max(MAX,team[min_idx][index_cnt[min_idx]])
    heapq.heappush(q,(team[min_idx][index_cnt[min_idx]],min_idx))

print(ans)
