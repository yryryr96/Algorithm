import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        
        Stack<Integer> tempBelt = new Stack<>();
        Queue<Integer> mainBelt = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
            mainBelt.add(i);
        }
        
        int cur = 0;
        
        while(!tempBelt.isEmpty() || !mainBelt.isEmpty()) {
            
            int target = order[cur];
            
            if (!tempBelt.isEmpty() && tempBelt.peek() == target) {
                tempBelt.pop();
                answer++;
                cur++;
            } else if(!mainBelt.isEmpty()) {
                
                if (mainBelt.peek() == target) {
                    mainBelt.poll();
                    answer++;
                    cur++;
                } else {
                    tempBelt.add(mainBelt.poll());
                }
            } else if (mainBelt.isEmpty()) break;
            
            if(cur >= n) break;
        }
        
        return answer;
    }
}