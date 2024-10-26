import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> beforeQ = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < enemy.length; i++) {
            int e = enemy[i];

            beforeQ.add(e);
            if (n >= e) {
                answer = i + 1;
                n -= e;
            } else {
                if (k <= 0) {
                    break;
                }
                
                while(!beforeQ.isEmpty()) {
                    
                    if (k <= 0) break;
                    
                    int v = beforeQ.poll();
                    n += v;
                    k--;
                    
                    if (n >= e) {
                        answer = i + 1;
                        n -= e;
                        break;
                    }
                }
            }
            // System.out.println("n = " + n + ", k = " + k);
        }
        
        return answer;
    }
}