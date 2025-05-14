import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        String[] numArr = numbers.split("");
        visited = new boolean[numArr.length];
        
        addNumberToSet(0, 0, "", numArr);
        
        for(int number : set) {
            if(isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void addNumberToSet(int depth, int idx, String num, String[] numArr) {
        
        if(depth > 0) {
            set.add(Integer.parseInt(num));
        }
        
        if (depth == numArr.length) {
            return;
        }
        
        for(int i = 0; i < numArr.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            addNumberToSet(depth+1, i+1, num + numArr[i], numArr);
            visited[i] = false;
        }
    }
    
    static boolean isPrime(int number) {
        
        if(number <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}