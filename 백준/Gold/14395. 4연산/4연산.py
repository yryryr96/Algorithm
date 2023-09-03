import sys
from collections import deque
input = sys.stdin.readline

a,b = map(int,input().split())

visited = set()
q = deque()
q.append((a,""))

if a == b :
    print(0)
    exit()

ans = []
while q :
    num, temp = q.popleft()

    if ans and len(temp) > len(ans[0]) : continue
    if num == b :
        ans.append(temp)
        continue

    if num < 0 : continue

    for k in ['*', '+', '-', '/'] :
        if k == '*' and num*num <= b :
            if num*num == b :
                q.append((num*num,temp + "*"))
                continue
            elif num*num not in visited :
                q.append((num*num,temp + '*'))
                visited.add(num*num)

        elif k == '+' and num+num <= b:
            if num + num == b:
                q.append((num*2,temp+'+'))
                continue
            elif num + num not in visited:
                q.append((num + num, temp + '+'))
                visited.add(num+num)

        elif k == '-' and 0 not in visited :
            q.append((0,temp+'-'))
            visited.add(0)

        elif num != 0 and k == '/' and 1 not in visited :
            q.append((1,temp+'/'))
            visited.add(1)

# print(ans)
if not ans : print(-1)
else : print(sorted(ans)[0])