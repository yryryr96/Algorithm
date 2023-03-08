a=input()
b=input()
sum=0
j=1
for i in range(3):
    x=int(a)*int(b[2-i])
    print(x)
    sum+=x*j
    j=j*10
print(sum)