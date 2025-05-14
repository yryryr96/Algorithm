import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int W = 0;
        int H = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            W = Math.max(W, Math.max(sizes[i][0], sizes[i][1]));
            H = Math.max(H, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        answer = W * H;
        return answer;
    }
}