import java.util.*;

class Solution {
    
    static int answer = 0;
    static int T;
    public int solution(int[] numbers, int target) {
        
        T = target;
        dfs(0, 0, 0, numbers);
        
        return answer;
    }
    
    static void dfs(int depth, int idx, int value, int[] numbers) {
        
        if (depth == numbers.length) {
            
            if (value == T) {
                answer++;
            }
            return;
        }
        
        for(int i = idx; i < numbers.length; i++) {
            dfs(depth+1, i+1, value + numbers[i], numbers);
            dfs(depth+1, i+1, value - numbers[i], numbers);
        }
    }
}