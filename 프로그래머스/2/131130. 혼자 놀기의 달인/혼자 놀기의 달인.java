import java.util.*;
class Solution {
    
    static boolean[] visited;
    static List<Integer> ans = new ArrayList<>();
    static int answer;
    
    public int solution(int[] cards) {
        
        answer = 0;
        int n = cards.length;
        visited = new boolean[n+1];
        
        for(int i = 0; i < n; i++) {
            if(!visited[cards[i]]) {
                visited[cards[i]] = true;
                dfs(cards[i], 1, cards);
            }
        }
        
        getAnswer(0, 0, 1);
        
        // System.out.println(ans.get(0));
        // for(int i = 0; i < ans.size(); i++) {
        //     System.out.println(ans.get(i));
        // }
        return answer;
    }
    
    static void getAnswer(int depth, int idx, int value) {
        
        if (depth == 2) {
            answer = Math.max(answer, value);
            return;
        }
        
        for(int i = idx; i < ans.size(); i++) {
            getAnswer(depth + 1, i + 1, value*ans.get(i));
        }
    }
    
    static void dfs(int idx, int cnt, int[] cards) {

        if (visited[cards[idx-1]]) {
            // System.out.println("cards[idx-1] = " + cards[idx-1]);
            ans.add(cnt);
            return;
        }
        
        else {
            visited[cards[idx - 1]] = true;
            dfs(cards[idx - 1], cnt + 1, cards);
        }
    }
}