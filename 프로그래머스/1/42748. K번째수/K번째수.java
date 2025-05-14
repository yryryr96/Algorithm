import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            answer[i] = getValue(array, command);
        }
        
        return answer;
    }
    
    static int getValue(int[] array, int[] command) {
        
        List<Integer> arr = new ArrayList<>();
        for(int idx = command[0]-1; idx <= command[1]-1; idx++) {
            arr.add(array[idx]);
        }
        
        Collections.sort(arr);
        return arr.get(command[2]-1);
    }
}