import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        HashMap<String, Integer> grade = new HashMap<>();
        
        for (int i=0; i<name.length; i++) {
            grade.put(name[i], yearning[i]);
        }
               
        for (int i=0; i<photo.length; i++) {
            int score = 0;
            for (int j=0; j<photo[i].length; j++) {
                if (grade.containsKey(photo[i][j])) {
                    score += grade.get(photo[i][j]);
                }
            }
            
            answer[i] = score;
        }
        return answer;
    }
}