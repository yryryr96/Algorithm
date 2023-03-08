from collections import deque
import sys
input = sys.stdin.readline

gears = [0] + list(deque(map(int,input().rstrip())) for _ in range(4))
def check_right(start,dirs):
    if start > 4 or gears[start-1][2] == gears[start][6] :
        return

    if gears[start-1][2] != gears[start][6] :
        check_right(start + 1, -dirs)
        gears[start].rotate(dirs)

def check_left(start,dirs):
    if start<1 or gears[start][2] == gears[start+1][6] :
        return

    if gears[start][2] != gears[start+1][6] :
        check_left(start - 1, -dirs)
        gears[start].rotate(dirs)


K = int(input().rstrip())
for _ in range(K):
    num, dirs = map(int,input().split())
    check_right(num+1,-dirs)
    check_left(num-1,-dirs)
    gears[num].rotate(dirs)

ans = 0
k = 1
for i in range(1,5):
    if gears[i][0] == 1:
        ans += k
    k*=2
print(ans)