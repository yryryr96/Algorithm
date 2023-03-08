import sys
input = sys.stdin.readline

N = int(input())
lst = []
ans = []
for _ in range(N):
    lst.append(input().rstrip())
lst.sort(key=len)

for i in range(len(lst)-1):
    for j in range(i+1,len(lst)):
        if len(lst[i]) == len(lst[j]):
            front = 0 ; back = 0

            for n in lst[i]:
                if n.isdigit() :
                    front += int(n)
            for n in lst[j]:
                if n.isdigit() :
                    back += int(n)

            if back < front :
                lst[i],lst[j] = lst[j], lst[i]

            elif front == back:
                if lst[i] > lst[j] :
                    lst[i],lst[j] = lst[j], lst[i]

for i in range(N):
    print(''.join(lst[i]))