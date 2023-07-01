import sys
input = sys.stdin.readline

visited = {}

def toDigit(bs):
    d = 0
    i = 1
    for j in range(len(bs) - 1, -1, -1):
        d += int(bs[j]) * i
        i *= 2
    return d

def erase(bs):
    nbs = ""
    for i in bs:
        if int(i) > 2:
            return ""
        if i != '(' and i != ')':
            nbs += i
    return nbs

def f(y, x, n):
    s = ""
    check = True
    temp = matrix[y][x]
    ny = y
    for i in range(n):
        nx = x
        for j in range(n):
            if temp != matrix[ny][nx]:
                check = False
            nx += 1
        ny += 1

    if check:
        s += '1' if temp else '0'
    else:
        length = n // 2
        s += '('
        s += f(y, x, length)
        s += f(y, x + length, length)
        s += f(y + length, x, length)
        s += f(y + length, x + length, length)
        s += ')'
    return s

def dfs1(bs):
    lv = 1
    if bs[0] == '(':
        cnt = 0
        nbs = ""
        for i in range(1, len(bs) - 1):
            if bs[i] == '(':
                cnt += 1
            elif bs[i] == ')':
                cnt -= 1
            nbs += bs[i]
            if cnt == 0:
                lv += dfs1(nbs)
                nbs = ""
    return lv

def dfs2(bs):
    lv = 1
    if bs in visited:
        return 0
    if bs[0] == '(':
        cnt = 0
        nbs = ""
        for i in range(1, len(bs) - 1):
            if bs[i] == '(':
                cnt += 1
            elif bs[i] == ')':
                cnt -= 1
            nbs += bs[i]
            if cnt == 0:
                lv += dfs2(nbs)
                if len(nbs) != 1:
                    visited[nbs] = True
                nbs = ""
    return lv

n, m = map(int, input().split())

l = 1
length = max(n, m)
while l < length:
    l *= 2

matrix = [[False] * 128 for _ in range(128)]

for i in range(n):
    input_str = input().rstrip()
    for j in range(m):
        matrix[i][j] = input_str[j] == '1'

bs = f(0, 0, l)

answer1 = dfs1(bs)
answer2 = dfs2(bs)

print(answer1, answer2)
