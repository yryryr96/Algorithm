import java.util.*;

class Solution {
    Queue<Long> Q1 = new LinkedList<>();
    Queue<Long> Q2 = new LinkedList<>();
    // Long qVal = 0l, q1Val = 0l, q2Val = 0l;
    long qVal = 0l, q1Val = 0l, q2Val = 0l;

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        int l1 = queue1.length;
        int l2 = queue2.length;

        for (int l = 0; l < l1; l++) {
            Q1.offer((long)queue1[l]);
            qVal += queue1[l];
            q1Val += queue1[l];
        }

        for (int l = 0; l < l2; l++) {
            Q2.offer((long)queue2[l]);
            qVal += queue2[l];
            q2Val += queue2[l];
        }

        if (qVal % 2l == 1l) return -1;

        qVal /= 2l;

        long tmp = 0l;
        while (qVal != q1Val) {
            answer++;

            if (qVal < q1Val) {
                tmp = Q1.poll();
                Q2.offer(tmp);

                q1Val -= tmp;
                q2Val += tmp;
            } else {
                tmp = Q2.poll();
                Q1.offer(tmp);

                q1Val += tmp;
                q2Val -= tmp;
            }

            if (answer > 1500000) return -1;
        }

        return answer;
    }
}