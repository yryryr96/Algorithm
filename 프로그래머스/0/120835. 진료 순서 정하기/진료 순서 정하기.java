import java.util.*;


class Solution {
    public int[] solution(int[] emergency) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        int[] temp = emergency.clone();
        Arrays.sort(temp);

        for (int num : emergency) {
            int index = Arrays.binarySearch(temp, num);
            answer.add(emergency.length - index);
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}