import java.util.*;
class Solution {
    
    static String[] vowels = {"A","E","I","O","U"};
    static ArrayList<String> dic = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        comb("");
        answer = dic.indexOf(word) + 1;
        return answer;
    }
    
    private static void comb(String word) {

        if (word.length() == 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            String str = word + vowels[i];
            if (!dic.contains(str)) {
                dic.add(str);
                comb(str);
            }
        }
    }
}