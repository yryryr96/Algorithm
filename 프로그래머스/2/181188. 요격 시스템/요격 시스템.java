import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        //단, 개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격할 수 없습니다.
        int cur = 0;
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        
        for(int[] t : targets){
            
            if(cur > t[0]) {
                continue;
            }
            
            cur = t[1];
            answer++;
        }
        
        return answer;
    }
}