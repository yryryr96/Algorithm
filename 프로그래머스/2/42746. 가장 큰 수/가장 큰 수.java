import java.util.*;
class Solution {
    
    public String solution(int[] numbers) {
        
        // string으로 변환하고 내림차순 정렬해서 붙이기
        int n = numbers.length;
        List<String> str = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int number = numbers[i];
            str.add(Integer.toString(number));
        }
        
        str.sort((a,b) ->  (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< n; i++) {
            sb.append(str.get(i));
        }
        
        String answer = sb.toString().charAt(0) == '0' ? "0" : sb.toString();
        return answer;
    }
}