word = input()
lst = [0]*(ord('z')-ord('a')+1)
for s in word :
    lst[ord(s) - ord('a')] += 1

print(*lst)
