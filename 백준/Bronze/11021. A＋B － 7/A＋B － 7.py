# a,b=map(int,input().split())
# a,b,c=map(int,input().split())
# 대문자 아스키 65~90
# 소문자 아스키 97~122
# List=[[_ for _ in range(5)] for _ in range(3)] >> 3*5 행렬 선언
# List=[i**3 for i in range()] >> i^3 을 리스트값으로 추가하며 리스트 선언
import sys
input = sys.stdin.readline

T = int(input())

for t in range(T) :
    a,b = map(int,input().split())
    print(f'Case #{t+1}: {a+b}')