import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        int n = book_time.length;
        int[][] time = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] s = book_time[i][0].split(":");
            String[] e = book_time[i][1].split(":");
            
            time[i][0] = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            time[i][1] = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        }
        
        // PriorityQueue<Integer> sq = new PriorityQueue<>((a,b) -> time[a][0] - time[b][0]);
        PriorityQueue<int[]> eq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        Arrays.sort(time, (a,b) -> a[0] - b[0]);
        
        int answer = 1;
        eq.add(time[0]);
        for(int i = 1; i < n; i++) {
            int[] cur = time[i];
            System.out.println("s = " + cur[0] + " e = " + cur[1]);
            if (eq.peek()[1] + 10 <= cur[0]) {
                eq.poll();
                eq.add(cur);
            } else {
                eq.add(cur);
                answer++;
            }
        }
                
        return answer;
    }
}