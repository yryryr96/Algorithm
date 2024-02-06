import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int w;
        int h;

        for (int i = 3; i < total; i++) {
            if (total%i == 0) {
                int b = calcB(total / i, i);
                int y = calcY(total, b);
                if (brown == b && y == yellow && total/i >= i) {
                    answer[0] = total/i;
                    answer[1] = i;
                    // System.out.println(Arrays.toString(answer));
                    return answer;
                }
            }
        }
        return answer;
    }

    private static int calcB (int w, int h) {

        return 2*w + (h-2)*2;
    }
    
    private static int calcY (int total, int brown) {
        return total - brown;
    }
}