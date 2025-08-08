import java.io.*;
import java.util.*;

class Solution {
    
    static int answer = 0;
    static int N;
    
    public int solution(int[] numbers, int target) {
        
        N = numbers.length;
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    static void dfs(int depth, int value, int[] numbers, int target) {
        
        if (depth == N) {
            if (value == target) {
                answer++;
            }
            return;
        }
       
        dfs(depth + 1, value + numbers[depth], numbers, target);
        dfs(depth + 1, value - numbers[depth], numbers, target);
    }
}