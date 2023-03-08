from collections import deque
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    A,B = map(int,input().split())
    q = deque()
    q.append((A,''))
    visited = [0]*10001
    while q:
        num,ans = q.popleft()
        visited[num] = 1
        if num == B :
            print(ans)
            break

        d_num = (num*2)%10000
        if visited[d_num] == 0:
            visited[d_num] = 1
            q.append((d_num,ans+'D'))

        if num == 0:
            s_num = 9999
        else:
            s_num = num - 1

        if visited[s_num] == 0 :
            visited[s_num] = 1
            q.append((s_num,ans+'S'))

        l_num = 10 * (num % 1000) + num // 1000
        if visited[l_num] == 0 :
            visited[l_num] = 1
            q.append((l_num,ans+'L'))

        r_num = 1000*(num%10) + num//10
        if visited[r_num] == 0 :
            visited[r_num] = 1
            q.append((r_num,ans+'R'))