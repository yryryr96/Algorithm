import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] lower = (my_string.toLowerCase()).split("");
        Arrays.sort(lower);
        answer = String.join("",lower);
                
        return answer;
    }
}