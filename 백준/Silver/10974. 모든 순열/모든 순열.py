import sys
input = sys.stdin.readline

n = int(input())
lst = list(range(1,n+1))
p = [0]*(n)
visited = [0]*(n)

def search(i,k):
    if i==k :
        print(*p)

    else :
        for j in range(k):
            if visited[j] == 0 :
                visited[j] = 1
                p[i] = lst[j]
                search(i+1,k)
                visited[j] = 0

search(0,n)
