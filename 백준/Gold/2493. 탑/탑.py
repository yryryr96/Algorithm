import sys
input = sys.stdin.readline
N = int(input())
st = []
lst = list(map(int,input().split()))
signal = [0]*(N+1)
# for j in range(1,N+1):
#     st.append([j,lst[j-1]])
#
# for i in range(N,-1,-1):
#     j = i-1
#     while j != 0:
#         if st[i][1] < st[j][1]:
#             signal[i] = j
#             break
#         j-=1
#
# print(*signal[1:])

for i in range(N):
    
    while st:
        if st[-1][1] > lst[i]:
            signal[i+1] = st[-1][0]
            break
        else :
            st.pop()

    st.append([i+1,lst[i]])

print(*signal[1:])