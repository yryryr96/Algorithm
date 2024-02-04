import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int i = 0, j = 0, k = 0;
        int num = 0;
        int[] rank = new int[3];
        ArrayList<Integer> answer = new ArrayList<>();
        while (num < answers.length) {

            int ans = answers[num];
            if (ans == one[i]) {
                rank[0]++;
            }

            if (ans == two[j]) {
                rank[1]++;
            }

            if (ans == three[k]) {
                rank[2]++;
            }

            i++;
            j++;
            k++;

            if (i == one.length) i = 0;
            if (j == two.length) j = 0;
            if (k == three.length) k = 0;

            num++;
        }

        int max = Arrays.stream(rank).max().getAsInt();
        for (int l = 0; l < 3; l++) {
            if (rank[l] == max) answer.add(l+1);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}