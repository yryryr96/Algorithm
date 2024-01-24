class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String findNumber = String.valueOf(k);
        
        for (int h=i; h<=j; h++) {
            String[] num = (String.valueOf(h)).split("");
            answer += count(num, findNumber);
        }
        return answer;
    }
    
    public static int count(String[] num, String findNumber) {
        int cnt = 0;
        for (String s : num) {
            if (s.equals(findNumber)) {
                cnt++;
            }
        }
        return cnt;
    }
}