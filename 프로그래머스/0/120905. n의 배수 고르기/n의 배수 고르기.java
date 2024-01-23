import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        List<Integer> numbers = new ArrayList<>();
        
        for (int number : numlist) {
            if (number % n == 0) {
                numbers.add(number);
            }
        }
        
        return numbers.stream().mapToInt(x->x).toArray();
    }
}