class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        for (int i = 0; i < k; i++) {
            int l = sb.length();
            int idx = l - 1;
            for (int j = 0; j < l-1; j++) {
                if (sb.charAt(j) < sb.charAt(j+1)) {
                    idx = j;
                    break;
                }
            }

            sb.deleteCharAt(idx);
        }

        return sb.toString();
    }
}