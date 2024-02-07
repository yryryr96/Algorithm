import java.util.*;
class Solution {
    
    static boolean[] visited;
    static int n;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        n = numbers.length;
        visited = new boolean[numbers.length];
        dfs(0, 0, numbers, target);
        answer = cnt;
        return answer;
    }
    
    private static void dfs(int depth, int value, int[] numbers, int target) {

        if (depth == n) {
            if (value == target) cnt++;
            return;
        }

        dfs(depth+1, value+numbers[depth], numbers, target);
        dfs(depth+1, value-numbers[depth], numbers, target);
    }
}