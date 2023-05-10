import sys
input = sys.stdin.readline

n = int(input())
histogram = []
for _ in range(n):
    h = int(input())
    histogram.append(h)

histogram.append(0)
# print(histogram)
st = []
ans = 0
for idx,h in enumerate(histogram) :
    while st and histogram[st[-1]] > h :
        H = histogram[st.pop()]
        W = idx-st[-1]-1 if st else idx
        ans = max(ans,H*W)
    st.append(idx)
print(ans)