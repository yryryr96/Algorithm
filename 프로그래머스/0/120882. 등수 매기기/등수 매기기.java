import java.util.*;

class Solution {
    public int[] solution(int[][] scores) {
        
        int[] answer = new int[scores.length];
        Integer[] avg = new Integer[scores.length];
        int[] temp = new int[scores.length];
        
        for (int i=0; i<scores.length; i++) {
            avg[i] = (scores[i][0] + scores[i][1]);
        } 
        
        for (int i=0; i<temp.length; i++) {
            temp[i] = avg[i];
        }
        
        Arrays.sort(avg, Collections.reverseOrder());
        
        for (int i=0; i<temp.length; i++) {
            answer[i] = Arrays.asList(avg).indexOf(temp[i]) + 1;
        }
        return answer;
    }
}