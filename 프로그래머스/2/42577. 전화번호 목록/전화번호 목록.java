import java.util.*;

class Solution {
    
    static Set<String> set = new HashSet<>();
    
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        Arrays.sort(phone_book, (a,b) -> Integer.compare(b.length(), a.length()));
        
        for(String p : phone_book) {
            set.add(p);
        }
        
        int minLength = phone_book[phone_book.length - 1].length();
        for(String phone : phone_book) {
            if(!checkWords(phone, minLength)) {
                answer = false;
                break;
            }
        }       
            
        return answer;
    }
    
    static boolean checkWords(String word, int minLength) {
        
        for(int endIndex = minLength; endIndex < word.length(); endIndex++) {
            String ngram = word.substring(0, endIndex);
            if(set.contains(ngram)) {
                return false;
            } 
        }
        
        return true;
    }
}