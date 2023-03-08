N = int(input())
switch = [0] + list(map(int,input().split()))
student = int(input()) # 학생의 수
for _ in range(student):
    sex, num = map(int,input().split()) # 1 남자 2 여자

    if sex == 1 :
        i = 1
        while num*i <= len(switch) -1:
            if switch[num*i] == 1:
                switch[num*i] = 0
            else :
                switch[num*i] = 1
            i += 1

    elif sex == 2 :
        if switch[num] == 0 :
            switch[num] = 1
        else :
            switch[num] = 0

        length = 0
        if (len(switch) -1) - num <= num -1 :
            length = len(switch) - num - 1
        else :
            length = num - 1

        for j in range(1,length+1):
            if switch[num-j] == switch[num+j]:
                if switch[num-j] == 0 :
                    switch[num-j]=switch[num+j] = 1
                else :
                    switch[num-j]=switch[num+j] = 0
            else :
                break

for i in range(1,N+1):
    print(switch[i], end = ' ')
    if i%20 == 0 :
        print()