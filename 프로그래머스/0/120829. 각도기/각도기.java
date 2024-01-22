class Solution {
    public int solution(int angle) {
        
        int answer = 0;
        
        if (0<angle && angle<90) {
            answer = 1;
            return answer;
        } 
        
        if (angle==90) {
            answer = 2;
            return answer;
        }
        
        if (90<angle && angle<180) {
            answer = 3;
            return answer;
        }
        
        if (angle == 180) {
            answer = 4;
            return answer;
        }
        
        return answer;
    }
}