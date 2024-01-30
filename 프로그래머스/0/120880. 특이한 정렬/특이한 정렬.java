import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        int gap = 10000;

        for (int i=0; i<numlist.length; i++) {
            int num = -1;
            gap = 10000;
            for (int j=0; j<numlist.length; j++) {
                if(!answer.contains(numlist[j]) && Math.abs(n-numlist[j]) < gap) {
                    num = numlist[j];
                    gap = Math.abs(n-numlist[j]);
                }
                if(!answer.contains(numlist[j]) && Math.abs(n-numlist[j]) == gap) {
                    num = num > numlist[j] ? num : numlist[j];
                }
            }
            answer.add(num);
        }
        
        return answer.stream().mapToInt(x->x).toArray();        
    }
}