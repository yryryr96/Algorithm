import java.util.*;
class Solution {
    
    static Set<Integer> checkList = new HashSet<>();
    static int size = 0;
    static String[] nums;
    static boolean[] visited;
    
    public int solution(String numbers) {
        
        int answer = 0;
        
        nums = numbers.split("");
        size = nums.length;
        visited = new boolean[size];
        
        dfs("");
        for (Integer n : checkList) {
            if (isPrime(n)) {
                System.out.println(n);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(String word) {
        
        if (word.length() == size) {
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if (!visited[i]) {
                
                visited[i] = true;
                checkList.add(Integer.parseInt(word+nums[i]));
                dfs(word + nums[i]);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        
        if(num == 0 || num == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}