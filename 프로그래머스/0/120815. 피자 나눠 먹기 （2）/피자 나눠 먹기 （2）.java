class Solution {
    public int solution(int n) {
        int answer = 0;
        int piece = 6;
        
        for (int i=1; i<=n; i++) {
            if ((i*piece)%n == 0) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}