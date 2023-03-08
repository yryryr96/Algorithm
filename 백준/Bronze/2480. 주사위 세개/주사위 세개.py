# a==b and a==c
a,b,c=map(int,input().split())
List=[a,b,c]
if a==b and a==c :
    print(10000+a*1000)

# (a=b) or (a=c) or (b=c)
elif a==b or a==c :
    print(1000+a*100)
elif b==c:
    print(1000+b*100)

#a!=b and b!=c and a!=c
if (a!=b and b!=c and a!=c) :
    print(max(List)*100)