import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        int answer = 0;
        int n = elements.length;
        Set<Integer> set = new HashSet<>();

        for(int cnt = 0; cnt < n; cnt++) {
           for(int i = 0; i < n; i++) {
                int sum = 0;
                if (i + cnt < n) {
                    for(int k = i; k <= i+cnt; k++) {
                        sum += elements[k];
                    }

                    set.add(sum);
                }
            
            else {
                for(int k = 0; k < i + cnt - n; k++) {
                    sum += elements[k];
                }

                for(int k = i; k < n; k++) {
                    sum += elements[k];
                }

                set.add(sum);
                }
               // System.out.println("sum = " + sum);
            }
            // System.out.println("size = " + set.size());
        }
    
        answer = set.size();
        
        return answer;
    }
}