import java.util.*;
class Solution {
    
    static int[] visited;
    static int n;

    public int solution(String begin, String target, String[] words) {
        
        n = words.length;
        visited = new int[n];
        int answer = bfs(begin, target, words);
        
        return answer;
    }
    
    static int bfs(String begin, String target, String[] words) {
        
        Queue<Integer> q = new LinkedList<>();
 
        for(int i = 0; i < n; i++) {
            if(canChange(begin, words[i])) {
                visited[i] = 1;
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            
            Integer curIdx = q.poll();
            
            if(words[curIdx].equals(target)) {
                return visited[curIdx];
            }
            
            for(int i = 0; i < n; i++) {
                if(curIdx != i && visited[i] == 0 && canChange(words[curIdx], words[i])) {
                    visited[i] = visited[curIdx] + 1;
                    q.add(i);
                }
            }
        }
        
        return 0;
    }
    
    static boolean canChange(String a, String b) {
        
        int size = a.length();
        int cnt = 0;
        for(int i = 0; i < size; i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if(ca != cb) cnt++;
            if(cnt > 1) return false;
        }
        
        return true;
    }
}