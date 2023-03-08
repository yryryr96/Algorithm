import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
stack = deque(range(1,N+1))

while len(stack)>1 :
    stack.popleft()
    stack.append(stack.popleft())

print(stack.pop())