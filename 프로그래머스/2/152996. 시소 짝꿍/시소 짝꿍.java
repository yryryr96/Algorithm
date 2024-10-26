import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        long[] cntWeights = new long[1001];
        long[] cntMul = new long[4001];
        
        for(int i = 0; i < weights.length; i++) {
            
            int w = weights[i];
            
            long cnt = cntWeights[w];
            long m2 = cntMul[w * 2];
            long m3 = cntMul[w * 3];
            long m4 = cntMul[w * 4];
            
            answer += cnt;
            answer += (m2 - cnt);
            answer += (m3 - cnt);
            answer += (m4 - cnt);
            
            cntWeights[w]++;
            cntMul[w*2]++;
            cntMul[w*3]++;
            cntMul[w*4]++;
        }
                
        return answer;
    }
}