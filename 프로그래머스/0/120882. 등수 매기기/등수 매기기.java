import java.util.*;

class Solution {
    public int[] solution(int[][] scores) {
        
        int[] answer = new int[scores.length];
        Integer[] avg = new Integer[scores.length];
        
        for (int i=0; i<scores.length; i++) {
            avg[i] = (scores[i][0] + scores[i][1]);
        } 
        
        Arrays.sort(avg, Collections.reverseOrder());
        
        for (int i=0; i<scores.length; i++) {
            answer[i] = Arrays.asList(avg).indexOf(scores[i][0] + scores[i][1]) + 1;
        }
        return answer;
    }
}