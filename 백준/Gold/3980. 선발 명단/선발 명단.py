import sys
input = sys.stdin.readline

T = int(input())
for tc in range(T) :
    ability = [list(map(int,input().split())) for _ in range(11)]
    position = [0]*11
    MAX = 0
    def dfs(i,p):
        global MAX

        if i == 11 :
            if MAX < sum(p) :
                MAX = sum(p)
            return

        for k in range(11) :
            if p[k] == 0 and ability[i][k] != 0:
                p[k] = ability[i][k]
                dfs(i+1,p)
                p[k] = 0

    dfs(0,position)
    print(MAX)

