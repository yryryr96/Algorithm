class Solution {
    public int solution(int[] side) {
        int answer = 0;
        int ans1 = 0;
        int ans2 = 0;
        
        int max = side[1] > side[0] ? side[1] : side[0];
        int min = side[1] < side[0] ? side[1] : side[0];
        // 새 값이 최대값 max + min > x > max -> x 개수 min + 1
        // max가 최대값  max - min < x < max
        
        answer = 2*min - 1;
        return answer;
    }
}