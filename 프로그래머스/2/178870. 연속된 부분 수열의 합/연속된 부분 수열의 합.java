import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int end = 0;
        int n = sequence.length;
        int minLength = Integer.MAX_VALUE;
        
        int sum = 0;
        int as = 0, ae = 0;
        
        for(int i = 0; i < n; i++) {
            
            while(end < n && sum < k) {
                sum += sequence[end];
                end++;
            } 
            
            if(sum == k) {
                int l = (end - 1) - i;
                if (minLength > l) {
                    as = i;
                    ae = end - 1;
                    minLength = l;
                }
            }
            
            sum -= sequence[i];
        }
        
        answer = new int[]{as,ae};
        
        return answer;
    }
}