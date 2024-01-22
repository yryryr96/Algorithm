class Solution {
    public int solution(int[] sides) {
        
        int sum = 0;
        int max = 0;
        
        int POSSIBLE = 1;
        int IMPOSSIBLE = 2;
        for (int num : sides) {
            sum += num;
            if (max < num) {
                max = num;
            }
        }
        
        sum -= max;
        if (sum > max) {
            return POSSIBLE;
        }
        return IMPOSSIBLE;
    }
}