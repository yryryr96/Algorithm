word = input()
cnt = [0]*26
for char in word :

    for i in range(97, 123):
        if i == ord(char) or i-32 == ord(char) :
            cnt[i-97] += 1

MAX = max(cnt)
if cnt.count(MAX) >= 2 :
    print('?')

else :
    a = cnt.index(MAX)
    print(chr(a+65))