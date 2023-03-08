# 백트래킹 연습문제 (boj 15650 : N과 M(2))
# i,j 중복없는 조합
N, M = map(int,input().split())
ans = []
st = []

def back(n):
    if len(ans) == M:
        print(' '.join(map(str,ans)))
        return

    else:
        for i in range(n,N+1):
            if i not in ans:
                ans.append(i)
                back(i)	# 오름차순 정렬 / back(i) 해도 결과 같게 나옴
                ans.pop()


back(1)