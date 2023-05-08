import sys
input = sys.stdin.readline

N,K,D = map(int,input().split())
students = []
algorithm = [0]*(K+1)
for _ in range(N):
    M,d = map(int,input().split())
    student_info = [d]
    student_algo = list(map(int,input().split()))
    student_info.append(student_algo)
    students.append(student_info)
students.sort()
# print(students)
start,end,E = 0,0,0
while start < N :
    while end < N and students[end][0] - students[start][0] <= D :
        for i in students[end][1] :
            algorithm[i] += 1
        end += 1

    total = every = 0
    for i in range(1,K+1):
        if algorithm[i] != 0 :
            total += 1
            if algorithm[i] == end - start :
                every += 1

    E = max(E,(total - every) * (end-start))
    for i in students[start][1]:
        algorithm[i] -= 1
    start += 1

print(E)