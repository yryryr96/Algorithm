import java.util.*;
class Solution {
    
    static int n, answer; 
    public int solution(int coin, int[] cards) {
        
        answer = 0;
        n = cards.length;
        
        Set<Integer> mine = new HashSet<>();
        Set<Integer> candidates = new HashSet<>();
        
        for(int i = 0; i < n/3; i++) {
            mine.add(cards[i]);
        }
        
        int idx = n/3;
        while(idx < n) {
            
            ++answer;
            
            int a = cards[idx];
            int b = cards[idx+1];
            candidates.add(a);
            candidates.add(b);
            // System.out.println("a = " + a + " , b = " + b);
            idx+=2;
            
            boolean flag = false;
            // 0개 고르기
            for(int m : mine) {
                if(mine.contains(n+1-m)) {
                    mine.remove(m);
                    mine.remove(n+1-m);
                    flag = true;
                    break;
                }
            }

            // 1개 고르기
            if(!flag && coin > 0) {
                for(int m : mine) {
                    if(candidates.contains(n+1-m)) {
                        mine.remove(m);
                        candidates.remove(n+1-m);
                        flag = true;
                        coin--;
                        break;
                    }
                }
            }

            //2개 고르기
            if(!flag && coin > 1) {
                for(int k : candidates) {
                    if(candidates.contains(n+1-k)) {
                        candidates.remove(k);
                        candidates.remove(n+1-k);
                        flag = true;
                        coin-=2;
                        break;
                    }
                }
            }

            if(!flag) break;
            if(idx == n) answer++;
        }
        
        return answer;
    }
}