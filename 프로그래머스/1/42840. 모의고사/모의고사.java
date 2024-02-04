import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] rank = new int[3];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            if (ans == one[i%5]) rank[0]++;
            if (ans == two[i%8]) rank[1]++;
            if (ans == three[i%10]) rank[2]++;
        }

        int max = Arrays.stream(rank).max().getAsInt();
        for (int l = 0; l < 3; l++) {
            if (rank[l] == max) answer.add(l+1);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}