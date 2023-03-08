import sys
from collections import deque
input = sys.stdin.readline
word = deque(input().rstrip())
k = len(word)
bomb = input().rstrip()
ans = []
# n = ''.join(word)
# while bomb in n :
#     n = n.replace(bomb,'')
#
# if n == '' :
#     print("FRULA")
# else :
#     print(n)

while word:
    ans.append(word.popleft())
    # word.pop(0) 하는 과정에서 리스트를 계속 새로 만들어 시간소요가 큰 듯
    if ''.join(ans[-len(bomb):]) == bomb:
        for _ in range(len(bomb)):
            ans.pop()

if not ans:
    print("FRULA")
else:
    print(''.join(ans))
