import sys
input = sys.stdin.readline

h,w = map(int,input().split())
ans = 0

if h == 1:
    ans = 1

elif h == 2 :
    if w >= 7:
        ans = 4
    elif w == 5 or w == 6:
        ans = 3
    elif w == 3 or w == 4:
        ans = 2
    elif w == 1 or w == 2 :
        ans = 1

else :
    if w >= 7 :
        ans = w - 2 # 5 + (w - 7)

    else :
        if w == 1 :
            ans = 1
        elif w == 2 :
            ans = 2
        elif w == 3 :
            ans = 3
        else :
            ans = 4
print(ans)