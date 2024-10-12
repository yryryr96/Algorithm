import java.util.*;
class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int maxDist = 0;
    
    public int solution(int n, int[][] edges) {
        
        visited = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs();
        
        int answer = 0;
        for(int i = 1; i < n+1; i++) {
            if(visited[i] == maxDist) answer++;
        }
        
        return answer;
    }
    
    static void bfs() {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        
        while(!q.isEmpty()) {
            
            int cur = q.poll();
            // System.out.println("cur = " + cur + " dist = " + visited[cur]);
            maxDist = Math.max(visited[cur], maxDist);
            List<Integer> nexts = graph.get(cur);
            for(int next : nexts) {
                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
    }
}