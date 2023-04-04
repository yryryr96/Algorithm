import sys
input = sys.stdin.readline

n,r,c = map(int,input().split())
cnt = 0
ans = 0
def div(i,j,N) :
    global cnt,ans
    if i <= r < i+N and j <= c < j + N :
        pass
    else :
        cnt += N**2
        return

    if N == 2 :
        for k in range(i,i+2):
            for n in range(j,j+2):
                if k == r and n == c :
                    ans = cnt
                    print(ans)
                    return
                cnt += 1
        return

    else:
        div(i,j,N//2)
        div(i,j+N//2,N//2)
        div(i+N//2,j,N//2)
        div(i+N//2,j+N//2,N//2)
    return

div(0,0,2**n)
