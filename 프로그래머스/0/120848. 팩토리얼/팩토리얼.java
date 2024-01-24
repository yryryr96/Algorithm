class Solution {
    public int solution(int n) {
        int answer = 0;
        int fac = 1;
        int i = 1;
        
        while (true) {
            fac *= i;
            if (fac > n) {
                break;
            }
            answer = i;
            i ++;
        }
        return answer;
    }
    
}