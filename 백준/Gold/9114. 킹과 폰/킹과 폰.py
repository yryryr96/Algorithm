import sys
input = sys.stdin.readline

T = int(input())
king = [[1,0],[0,1],[-1,0],[0,-1],[1,1],[1,-1],[-1,1],[-1,-1]]
pawn = [1,0]

def getMovingWarning(x,y,stops) :
    mw = []
    if y+1<8 :
        if (x-1>=0 and (y+1,x-1) not in stops) :
            mw.append((y+1,x-1))
        if (x+1 < 8 and (y+1,x+1) not in stops) :
            mw.append((y+1,x+1))
    return mw


def move(xk,yk,xp,yp,warnings,stops) :
    white  = False

    movingWarnings = getMovingWarning(xp,yp,stops)
    banList = warnings + stops + movingWarnings
    canMove = []
    for di,dj in king :
        ni,nj = yk+di, xk+dj
        if 0<=ni<8 and 0<=nj<8 and (ni,nj) not in banList :
            canMove.append((ni,nj))

    # print((yk,xk),canMove)
    if not canMove : return white

    for y,x in canMove :
        if yp == y and xp == x :
            white = True

        if ((yp+1,xp) in stops) or (yp+1 == y and xp == x) :
            white = True

        if white : break

        else :
            if yp + 1 == 8 :
                continue
            white = move(x,y,xp,yp+1,warnings,stops)

    return white

# 금지 둘다 x, 위험 폰만, 폰 왼,오른 아래 위험 칸
for _ in range(T):
    graph = [list(input().rstrip()) for _ in range(8)]

    warnings = [] # 위험
    stops = [] # 멈춤

    for i in range(8):
        for j in range(8):
            if graph[i][j] == 'D' : warnings.append((i,j))
            elif graph[i][j] == 'F' : stops.append((i,j))

    xk,yk = map(int,input().split())
    xp,yp = map(int,input().split())
    xk -= 1; yk=8-yk; xp-=1; yp=8-yp;

    result = move(xk,yk,xp,yp,warnings,stops)
    if result : print("White")
    else : print("Black")
