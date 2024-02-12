import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] total = new int[n+1];
        
        Arrays.fill(total, 1);
        
        for (int i : lost) {
            total[i] -= 1;
        }

        for (int i : reserve) {
            total[i] += 1;
        }

        for (int i = 0; i < total.length; i++) {
            if (total[i] == 0) {
                if (total[i-1] == 2) {
                    total[i] += 1;
                    total[i-1] -= 1;
                }

                else if (i+1 <= n && total[i+1] == 2) {
                    total[i] += 1;
                    total[i+1] -= 1;
                }
            }
        }

        for (int i = 1; i < total.length; i++) {
            if (total[i] >= 1) answer ++;
        }
        return answer;
    }
}