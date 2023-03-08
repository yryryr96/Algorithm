import sys
input = sys.stdin.readline

while True :
    string = input().rstrip()
    if string == '.' :
        break

    st = []
    temp = 1
    for s in string :
        if s == '(' or s == '[':
            st.append(s)
        elif s == ')' :
            if st and st[-1] == '(':
                st.pop()
            else :
                temp = 0
                break
        elif s == ']':
            if st and st[-1] == '[':
                st.pop()
            else:
                temp = 0
                break

    if not st and temp == 1:
        print('yes')
    else :
        print('no')