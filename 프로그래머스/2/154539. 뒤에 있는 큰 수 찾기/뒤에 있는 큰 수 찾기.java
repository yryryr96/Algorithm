import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        Stack<Integer> st = new Stack<>();
        st.add(0);
        
        for(int i = 1; i < n; i++) {
            
            int num = numbers[i]; 
            while(!st.isEmpty()) {
                
                int idx = st.peek();
                if(numbers[idx] < num) {
                    answer[idx] = num;
                    st.pop();
                }
                
                else break;
            }
            
            st.add(i);
        }
        
        for(int i = 0; i < n; i++) {
            if (answer[i] == 0) answer[i] = -1;
        }
        
        return answer;
    }
}