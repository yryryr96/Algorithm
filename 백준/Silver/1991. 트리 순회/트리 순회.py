import sys
input = sys.stdin.readline
n = int(input())
lst = [0]*(n+1)
left = [0]*(n+1)
right = [0]*(n+1)

for _ in range(n):
    a,b,c = input().split()
    lst[ord(a) - 64] = a
    if b != '.':
        left[ord(a)-64] = b

    if c != '.' :
        right[ord(a)-64]  = c
def preorder(v):
    print(lst[v],end='')
    if left[v] != 0:
        preorder(ord(left[v])-64)
    if right[v] != 0:
        preorder(ord(right[v])-64)
def inorder(v):
    if left[v] != 0 :
        inorder(ord(left[v])-64)
    print(lst[v],end='')
    if right[v] != 0 :
        inorder(ord(right[v])-64)

def postorder(v):
    if left[v] != 0:
        postorder(ord(left[v])-64)
    if right[v] != 0:
        postorder(ord(right[v])-64)
    print(lst[v],end='')

preorder(1)
print()
inorder(1)
print()
postorder(1)