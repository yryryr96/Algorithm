N = int(input())
lst = list(map(int,input().split()))
student = list(range(1,N+1))

for i in range(1,N):
    a = student.pop(i)
    student.insert(i-lst[i],a)
print(*student)


