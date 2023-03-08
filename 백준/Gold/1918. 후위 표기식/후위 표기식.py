words = input()
pr = {'*': 2 , '/' : 2, '+' : 1, '-': 1 , '(' : 0 }
st = []
ans = []

for i in range(len(words)) :
    if words[i].isalpha() :
        ans.append(words[i])


    elif words[i] == '(':
        st.append(words[i])

    elif words[i] == ')' and st :
        while st and st[-1] != '(' :
            ans.append(st.pop())
        st.pop()

    else:
        if st :
            while pr[words[i]] <= pr[st[-1]] :
                ans.append(st.pop())
                if not st:
                    break
            st.append(words[i])

        else :
            st.append(words[i])

while st:
    ans.append(st.pop())

print(''.join(ans))