T=int(input())
ans=[]

for i in range(T):
    a,b=map(int,input().split())
    x=a+b
    ans.append(x)
for j in range(T):
    print(ans[j])