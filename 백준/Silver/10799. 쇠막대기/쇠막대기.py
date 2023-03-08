import sys
input = sys.stdin.readline
lst = list(input())
st = [] ; cnt = 0
i = 0
for i in range(len(lst)) :
    if lst[i] == '(' and lst[i+1] == ')' :
        cnt += len(st)

    elif lst[i] == '(' :
        st.append('(')

    elif lst[i] == ')' and lst[i-1] != '(':
        st.pop()
        cnt += 1

print(cnt)
