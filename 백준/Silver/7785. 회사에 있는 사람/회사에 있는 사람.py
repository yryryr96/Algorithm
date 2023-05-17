import sys
input=sys.stdin.readline

n = int(input())
people = set()
for _ in range(n):
    name, check = input().split()
    if check == 'enter' :
        people.add(name)
    else :
        people.remove(name)

people = sorted(people,reverse=True)
for a in people:
    print(a)