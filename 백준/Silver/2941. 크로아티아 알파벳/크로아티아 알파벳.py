late_Alpha = ['c=','c-','dz=','d-','lj','nj','s=','z=']

cnt = 0

n = input()

for k in range(len(late_Alpha)):
    if late_Alpha[k] in n :
        cnt += n.count(late_Alpha[k])
        n = n.replace(late_Alpha[k],'.')
n = n.replace('.','')
for i in range(len(n)):
    cnt += 1

print(cnt)


