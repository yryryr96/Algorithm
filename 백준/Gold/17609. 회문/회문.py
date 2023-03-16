import sys
input = sys.stdin.readline
n = int(input())
for _ in range(n):
    word = input().strip()
    start = 0
    end = len(word) - 1
    temp = temp_s = temp_e = 0
    cnt = 0
    while start <= end:
        if word[start] == word[end]:
            if start == end :
                break
            start += 1
            end -= 1

        else:
            if len(word) == 2:
                temp = 2
                break

            temp = 1
            temp_s = start + 1
            temp_e = end - 1

            break

    if temp_s and temp_e :
        while temp_s <= end:
            if word[temp_s] == word[end]:
                temp_s += 1
                end -= 1
            else:
                cnt += 1
                break

        while start <= temp_e:
            if word[start] == word[temp_e]:
                start += 1
                temp_e -= 1

            else:
                cnt += 1
                break

    if cnt == 2:
        temp = 2

    print(temp)