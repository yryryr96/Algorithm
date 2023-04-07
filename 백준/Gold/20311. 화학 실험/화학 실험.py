n, k = map(int, input().split())
c = list(map(int, input().split()))

if max(c) > (n+1)//2:
    print("-1")
else:
    # 누적합 배열 생성
    prefix_sum = [0] * (k+1)
    for i in range(1, k+1):
        prefix_sum[i] = prefix_sum[i-1] + c[i-1]

    # 해당 색깔을 가진 시약이 있는 시험관 리스트 생성
    tube_list = [[] for _ in range(k+1)]
    for i in range(1, k+1):
        for j in range(prefix_sum[i-1]+1, prefix_sum[i]+1):
            tube_list[i].append(j)

    # 시험관 배열 구성
    result = [0] * n
    idx = 0
    for i in range(1, k+1):
        for j in range(len(tube_list[i])):
            result[idx] = i
            idx += 2
            if idx >= n:
                idx = 1

    print(" ".join(map(str, result)))
