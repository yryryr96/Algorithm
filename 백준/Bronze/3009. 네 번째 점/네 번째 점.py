import sys
visited_a = [0]*1001
visited_b = [0]*1001
for _ in range(3):
    a,b = map(int,input().split())
    visited_a[a] += 1
    visited_b[b] += 1
a = 0
b = 0
for i in range(1001):
    if visited_a[i] == 1 : a = i
    if visited_b[i] == 1 : b = i

print(a,b)