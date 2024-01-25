import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int minValue = 100;
                
        Arrays.sort(array);
        
        for (int i=0; i<array.length; i++) {
            
            if (Math.abs(array[i]-n) < minValue) {
                minValue = Math.abs(array[i]-n);        
                answer = array[i];
            }
        }
        return answer;
    }
}