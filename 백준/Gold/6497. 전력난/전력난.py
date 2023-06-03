import sys

input = sys.stdin.readline

#유니온 파인드 알고리즘을 통해 부모 노드를 통일
def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(x, y):
    x, y = find(x), find(y)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y


while True:
    m, n = map(int, input().split())
    if m == 0 and n == 0: 
        break
    parent = [i for i in range(m)]
    result = 0
    
    edges = []
    for _ in range(n):
        n1, n2, dist = map(int, input().split()) 
        edges.append((n1, n2, dist))

    edges.sort(key=lambda x: x[2]) 

    for edge in edges:
        u, v, w = edge
        if find(u) != find(v): #유니온 파인드로 부모 노드가 같은지 보고, 아니라면 통일해줍니다.
            union(u, v)
        else: #문제에서 원하는 것이 절약되는 액수이므로, 연결되지 않은 간선의 가중치를 더해줍니다.
            result += w
    print(result)