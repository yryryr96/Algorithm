import sys
input = sys.stdin.readline
a = int(input())
b = int(input())
c = int(input())
numbers = [0]*10
number = a*b*c
for i in str(number):
    numbers[int(i)] += 1
for i in numbers :
    print(i)