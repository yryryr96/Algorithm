class Solution {
    public int solution(int n) {
        
        int townNumber = 1;

        for (int i=2; i<=n; i++) {

            townNumber += 1;
            if (townNumber%3 == 0 || String.valueOf(townNumber).contains("3")) {
                while (townNumber%3 == 0 || String.valueOf(townNumber).contains("3")) {
                    townNumber += 1;
                }
            }
        }
        
        return townNumber;
    }
}