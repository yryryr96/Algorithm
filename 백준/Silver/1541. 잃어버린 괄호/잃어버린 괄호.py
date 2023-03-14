# '-' 나오고 그 다음 '-' 나올때까지 다 더해서 한번에 빼주기
import sys
input = sys.stdin.readline

string = input().split('-')

for i in range(len(string)):
    ans = 0
    temp = ''
    for j in range(len(string[i])):
        if string[i][j].isdigit() :
            temp += string[i][j]
        else :
            ans += int(temp)
            temp = ''
    if temp :
        ans+=int(temp)

    string[i] = ans

ans = string[0]
for i in range(1,len(string)):
    ans -= string[i]

print(ans)