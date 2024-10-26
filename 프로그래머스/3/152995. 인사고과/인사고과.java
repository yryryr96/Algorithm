import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int n = scores.length;
        int score1 = scores[0][0];
        int score2 = scores[0][1];
        
        Arrays.sort(scores, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        // 근무태도는 이미 내림차순으로 정렬
        // 즉, 동료 평가만 비교 -> 오름차순
        int max = scores[0][1];
        for(int i = 1; i < n; i++) {
            int[] s = scores[i];
            if (s[1] < max) {
                
                if (s[0] == score1 && s[1] == score2) {
                    return -1;
                }
                
                s[0] = -1; s[1] = -1;
            } else {
                max = s[1];
            }
        }
        
        // 합한 점수 기준 내림차순 정렬
        Arrays.sort(scores, (a,b) -> (b[0] + b[1]) - (a[0] + a[1]));
        
        for(int i = 0; i < n; i++) {
            
            answer++;
            if (scores[i][0] == score1 && scores[i][1] == score2) {
                return answer;
            }
        }
        
        return answer;
    }
}