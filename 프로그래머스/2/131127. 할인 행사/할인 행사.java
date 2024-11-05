import java.util.*;

class Solution {
    
    static int flag = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        Map<String, Integer> info = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            info.put(want[i], i);
        }
        
        int[] visited = new int[number.length];
        for(int i = 0; i < 10; i++) {
            
            int idx = info.getOrDefault(discount[i], -1);
            if(idx == -1) {
                flag--;
                continue;
            }
            visited[idx]++;
        }
        
        if(compare(number, visited)) answer++;
        
        int s = 0;
        int e = 9;
        
        while(e < discount.length - 1) {
            
            // System.out.println("s : " + s + " e : " + e + " flag : " + flag);
            int startIdx = info.getOrDefault(discount[s], -1);
            int endIdx = info.getOrDefault(discount[e+1], -1);
            
            if(startIdx == -1) {
                flag++;
            } else {
                visited[startIdx]--;
            }
            
            if(endIdx == -1) {
                flag--;
            } else {
                visited[endIdx]++;
            }
            
            // StringBuilder sb = new StringBuilder();
            // for(int i = 0; i < visited.length; i++) {
            //     sb.append(visited[i] + " ");
            // }
            // System.out.println(sb.toString());
            if(compare(number, visited)) answer++;
            
            s++;
            e++;
        }    
        
        return answer;
    }
    
    static boolean compare(int[] number, int[] visited) {
        
        if(flag < 0) return false;
        for(int i = 0; i < number.length; i++) {
            if(number[i] != visited[i]) return false;
        }
        
        return true;
    }
}