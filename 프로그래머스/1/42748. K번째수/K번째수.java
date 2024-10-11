import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int size = commands.length;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++) {
            
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1] - 1;
            int target = command[2] - 1;
            
            List<Integer> arr = new ArrayList<>();
            for(int k = start; k <= end; k++) {
                arr.add(array[k]);
            }
            
            Collections.sort(arr);
            answer[i] = arr.get(target);

        }
        
        return answer;
    }
}