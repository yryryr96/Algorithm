class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n == 1 || n == 2) {
            return answer;
        }
        
        for (int i=3; i<=n; i++) {
            for (int j=2; j<i; j++) {
                if (i%j==0) {
                    answer++;
                    break;
                } 
            }    
        }
        
        return answer;
    }
}