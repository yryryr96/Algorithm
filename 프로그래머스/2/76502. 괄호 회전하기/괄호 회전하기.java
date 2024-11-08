import java.util.*;
class Solution {
    
    static int answer = 0;
    static int n;
    static Map<Character, Integer> charMap = new HashMap<>();
    public int solution(String s) {
        
        n = s.length();
        initMap();
        
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.add(s.charAt(i));
        }
        
        for(int i = 0; i < n - 1; i++) {
            
            char[] cArr = initCharArr(q);
            // System.out.println(new String(cArr) + " " + answer);
            getAnswer(cArr);
            
            q = initQueue(cArr);
        }
        
        return answer;
    }
    
    static void initMap() {
        charMap.put('[', 3);
        charMap.put(']', -3);
        charMap.put('{', 2);
        charMap.put('}', -2);
        charMap.put('(', 1);
        charMap.put(')', -1);
    }
    
    static char[] initCharArr(Queue<Character> q) {
        
        char[] arr = new char[n];
        for(int i = 0; i < n; i++) {
            arr[i] = q.poll();
        }
        
        return arr;
    }
    
    static Queue<Character> initQueue(char[] c) {
        
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.add(c[i]);
        }
        
        char v = q.poll();
        q.add(v);
        
        return q;
    }
    
    static void getAnswer(char[] cArr) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            
            if(charMap.get(cArr[i]) > 0) st.add(cArr[i]);
            else {
                if(st.isEmpty()) return;
                char c = st.pop();
                if(charMap.get(c) + charMap.get(cArr[i]) != 0) return;
            }
        }
        
        if(!st.isEmpty()) return;
        
        answer++;
    }
}