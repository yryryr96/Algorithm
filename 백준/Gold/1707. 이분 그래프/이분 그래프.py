import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def dfs(i,group):
    visited[i] = group
    for v in graph[i] :
        if visited[v] == 0 :
            temp = dfs(v,-group)
            # print(i,v)
            if not temp : return False
        else :
            if visited[v] != -group :
                return False
    return True

T = int(input())
for t in range(T):

    V,E = map(int,input().split())
    graph = [[] for _ in range(V+1)]
    visited = [0]*(V+1)
    for _ in range(E):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)

    temp = 0
    for i in range(1,V+1) :
        if visited[i] == 0 :
            if not dfs(i,1) :
                print("NO")
                temp = 1
                break
    if not temp :
        print("YES")