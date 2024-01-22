import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        
        String answer;
        StringBuilder sb = new StringBuilder();
        
        String[] sa = my_string.split("");
        
        for (int i=0; i<=sa.length-1; i++) {
            sb.append(sa[i].repeat(n));
        }
        
        answer = sb.toString();
        return answer;
    }
}