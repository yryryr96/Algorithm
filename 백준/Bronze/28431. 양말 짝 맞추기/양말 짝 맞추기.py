numbers = []
check = set()
for _ in range(5):
    a = int(input())
    numbers.append(a)
    check.add(a)

for i in check :
    if numbers.count(i) % 2 == 1 :
        print(i)
        break
