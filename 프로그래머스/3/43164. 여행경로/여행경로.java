import java.util.*;
class Solution {
    
    static boolean[] visited;
    static int size;
    static List<String> answers = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        size = tickets.length;
        visited = new boolean[size];
        
        dfs(0, "ICN", tickets, "ICN");
        
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        
        return answer;
    }
    
    static void dfs(int depth, String cur, String[][] tickets, String way) {
        
        if (depth == size) {
            answers.add(way);
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if(!visited[i] && cur.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], tickets, way + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}