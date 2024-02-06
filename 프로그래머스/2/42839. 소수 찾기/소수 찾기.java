import java.util.*;
class Solution {
    
    static ArrayList<String> arr = new ArrayList<>();
    static int n;
    static boolean[] visited;
    
    public int solution(String numbers) {
        
        int answer = 0;
        
        n = numbers.length();
        visited = new boolean[n];
        String[] str = numbers.split("");
        ArrayList<Integer> nums = new ArrayList<>();
        dfs("", str);
        for (int i = 0; i < arr.size(); i++) {
            int num = Integer.parseInt(arr.get(i));
            if (!nums.contains(num)) nums.add(num);
        }

        for (Integer num : nums) {
            if (check(num)) answer++;
        }
        return answer;
    }
    
    private static void dfs(String word, String[] str) {

        if (word.length() == n) {
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!visited[i]) {

                visited[i] = true;
                arr.add(word + str[i]);
                dfs(word + str[i], str);
                visited[i] = false;
            }
        }
    }
    
    private static boolean check(Integer num) {

        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}