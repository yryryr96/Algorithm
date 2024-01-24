import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] bc = before.toCharArray();
        char[] ac = after.toCharArray();
        
        Arrays.sort(bc);
        Arrays.sort(ac);
        
        String beforeToString = new String(bc);
        String afterToString = new String(ac);
        
        if (beforeToString.equals(afterToString)) {
            answer = 1;
        }
        return answer;
    }
}