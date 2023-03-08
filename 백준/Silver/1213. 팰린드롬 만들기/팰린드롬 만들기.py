import sys
input = sys.stdin.readline
word = list(input().rstrip())
ans = ''
center = []
cnt = 0
if len(word) == 2:
    if word[0]!=word[1]:
        cnt = sys.maxsize

for n in word:
    if word.count(n) %2 == 1:
        if n not in center:
            cnt += 1
            center.append(n)
        if cnt > 1:
            break
if center:
    word.remove(center[0])

word.sort()
left =''
right=''
for i in range(0,len(word),2):
    left += word[i]
for j in range(1,len(word),2):
    right = word[j] + right

if cnt > 1:
    print("I'm Sorry Hansoo")
else:
    if center:
        print(left+center[0]+right)
    else:
        print(left+right)

