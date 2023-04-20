import sys
from itertools import permutations
input = sys.stdin.readline

n,k = map(int,input().split())
rps = [list(map(int,input().split())) for _ in range(n)]
p2 = list(map(int,input().split())) # 경희
p3 = list(map(int,input().split())) # 민호
jiwoo = list(range(1,n+1))

def dfs(np1,np2,wp,board,game_cnt):
    global temp
    if wp[0] == k :
        temp = 1
        return

    if wp[1] == k or wp[2] == k :
        return

    if game_cnt[0] == n :
        return

    np3 = 3 - (np1 + np2) # 다음 순서 선수

    np1_value = board[np1][game_cnt[np1]] - 1 # 가위바위보는 1부터 시작인데
    np2_value = board[np2][game_cnt[np2]] - 1 # rps index 는 0부터 시작
    game_cnt[np1] += 1
    game_cnt[np2] += 1

    if rps[np1_value][np2_value] == 2 or (rps[np1_value][np2_value] == 1 and np1 > np2) :
        wp[np1] += 1
        dfs(np1,np3,wp,board,game_cnt)

    elif rps[np1_value][np2_value] == 0 or (rps[np1_value][np2_value] == 1 and np1 < np2) :
        wp[np2] += 1
        dfs(np2,np3,wp,board,game_cnt)


for p1 in permutations(jiwoo,n) :
    board = [p1,p2,p3]
    game_cnt = [0,0,0] # 몇번째 게임인지
    wp = [0,0,0] # win point
    temp = 0
    dfs(0,1,wp,board,game_cnt)
    if temp == 1 :
        print(1)
        break
else:
    print(0)