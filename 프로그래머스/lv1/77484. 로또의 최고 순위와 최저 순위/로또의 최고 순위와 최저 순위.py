def solution(lottos, win_nums):
    answer = []
    
    rank = [6,6,5,4,3,2,1]
    
    cnt1 = cnt2 = 0
    for num in lottos :
        if num != 0 and num in win_nums :
            cnt1 += 1
        
        elif num == 0 :
            cnt2 += 1
        
    ans = [rank[cnt1+cnt2],rank[cnt1]]
            
    return ans