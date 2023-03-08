import copy
import sys
input = sys.stdin.readline

List=[]
for _ in range(10):
    n = int(input())
    List.append(n%42)

print(len(set(List)))