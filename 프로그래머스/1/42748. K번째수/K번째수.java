import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int idx = command[2];

            int[] temp = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(temp);
            answer[i] = temp[idx-1];
        }
        return answer;
    }
}