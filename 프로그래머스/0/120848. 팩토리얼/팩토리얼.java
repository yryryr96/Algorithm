class Solution {
    public int solution(int n) {
        int answer = 0;
        int fac = 1;
        int i = 1;
        
        while (true) {
            fac = factorial(i);
            if (fac > n) {
                break;
            }
            answer = i;
            i ++;
        }
        return answer;
    }
    
    public static int factorial(int num) {
        
        int ans = 1;
        for (int i=1; i<=num; i++) {
            ans*=i;
        }
        return ans;
    }
}