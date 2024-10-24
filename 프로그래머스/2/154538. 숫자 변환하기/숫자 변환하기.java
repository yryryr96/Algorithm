import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int[] visited = new int[y+1];
        Arrays.fill(visited, -1);
        visited[x] = 0;
        
        while(!q.isEmpty()) {
            
            int cur = q.poll();
            if (cur == y) break;
            
            int[] next = new int[]{cur + n, cur*2, cur*3};
            for(int num : next) {
                if(num <= y && visited[num] == -1) {
                    visited[num] = visited[cur] + 1;
                    q.add(num);
                }
            }
        }
        
        answer = visited[y];
        
        return answer;
    }
}