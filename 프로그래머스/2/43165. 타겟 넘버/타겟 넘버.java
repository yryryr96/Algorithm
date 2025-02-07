import java.util.*;

class Solution {
    
    static int TARGET_NUMBER;
    static int[] NUMBERS;
    static int ANSWER = 0;
    static int NUMBERS_SIZE;
    
    public int solution(int[] numbers, int target) {
        
        NUMBERS = numbers;
        TARGET_NUMBER = target;
        NUMBERS_SIZE = numbers.length;
        
        dfs(0, 0);
        
        return ANSWER;
    }
    
    static void dfs(int depth, int value) {
        if (depth == NUMBERS_SIZE) {
            if (value == TARGET_NUMBER) {
                ANSWER++;
            }
            return;
        }
        
        int nextValue = NUMBERS[depth];
        dfs(depth+1, value + nextValue);
        dfs(depth+1, value - nextValue);
    }
}