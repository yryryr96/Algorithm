import java.util.*;
class Solution {
    
    static int n;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        n = numbers.length;
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    static void dfs(int depth, int v, int[] numbers, int target) {
        
        if(depth == n) {
            if (v == target) answer++;
            return;
        }
        
        // System.out.println(v);
        dfs(depth + 1, v + numbers[depth], numbers, target);
        dfs(depth + 1, v - numbers[depth], numbers, target);
    }
}