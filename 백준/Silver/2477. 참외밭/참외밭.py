K = int(input())
lst = [list(map(int,input().split())) for _ in range(6)]

w = 0; w_idx = 0
h = 0; h_idx = 0
for i in range(len(lst)):
    if lst[i][0] == 1 or lst[i][0] == 2 :
        if w < lst[i][1] :
            w = lst[i][1]
            w_idx = i
    elif lst[i][0] == 3 or lst[i][0] == 4 :
        if h < lst[i][1] :
            h = lst[i][1]
            h_idx = i

sub_w = abs(lst[(w_idx-1)%6][1] - lst[(w_idx+1)%6][1])
sub_h = abs(lst[(h_idx-1)%6][1] - lst[(h_idx+1)%6][1])

ans = ((w*h) - (sub_w*sub_h))*K
print(ans)

# 가장 긴 변의 양 옆에 가로세로 빼서 작은 사각형의 넓이를 구해준다.