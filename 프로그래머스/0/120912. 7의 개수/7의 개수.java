class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int num : array) {
            answer += countSeven(num);
        }
        return answer;
    }
    
    public static int countSeven(int number) {
        
        String s = Integer.toString(number);
        return (int) s.chars().filter(i -> String.valueOf((char) i).equals("7")).count();
    }
}