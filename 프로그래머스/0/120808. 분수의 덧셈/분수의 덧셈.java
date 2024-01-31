class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        numer1 *= denom2;
        numer2 *= denom1;
        denom1 *= denom2;

        int up = numer1 + numer2;
        int down = denom1;
        int dv = up < down ? up : down;

        for (int i = 2; i <= dv; i++) {
            if (up % i == 0 && down % i == 0) {
                while (up % i == 0 && down % i == 0) {
                    up /= i;
                    down /= i;
                }
            }
        }
        int[] answer = {up, down};
        return answer;
    }
}