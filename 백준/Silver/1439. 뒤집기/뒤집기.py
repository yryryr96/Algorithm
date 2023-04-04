import sys
input = sys.stdin.readline

number = input().rstrip()
n = len(number)
i = 0
ans = []
while i < n :
    if number[i] == '0':
        ans.append('0')
        while i<n :
            if number[i] == '0' :
                i+=1
            else :
                break
    else :
        ans.append('1')
        while i<n :
            if number[i] == '1' :
                i+=1
            else:
                break

ans = min(ans.count('0'),ans.count('1'))
print(ans)

