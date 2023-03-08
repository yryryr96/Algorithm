X=int(input())
N=int(input())
rec=[]
for i in range(N):
    a,b=map(int,input().split())
    rec.append(a*b)

if X==sum(rec):
    print("Yes")

else:
    print("No")