import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        Map<String, Integer> map = getMap(clothes);
        for (String s : map.keySet()) {
            answer *= (map.get(s)+1);
        }
        answer--;
        return answer;
    }
    
    private static Map<String, Integer> getMap(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
                continue;
            }

            map.put(cloth[1], 1);
        }

        return map;
    }
}