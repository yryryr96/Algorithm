import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        int idx = 0;

        while (st.size() < prices.length) {

            int temp = 0;
            st.add(prices[idx]);
            for (int i = idx; i < prices.length; i++) {
                temp = i;
                if (prices[i] < st.peek()) break;
            }

            answer.add(temp - idx);
            idx++;
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}