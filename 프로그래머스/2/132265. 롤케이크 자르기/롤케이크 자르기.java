class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] a = new int[10001];
        int[] b = new int[10001];
        int aCnt = 0, bCnt = 0;
        for(int i = 0; i < topping.length; i++) {
            
            a[topping[i]]++;
            if(a[topping[i]] == 1) aCnt++;
        }
        
        for(int i = 0; i < topping.length - 1; i++) {
            b[topping[i]]++;
            if(b[topping[i]] == 1) bCnt++;
            a[topping[i]]--;
            if(a[topping[i]] == 0) aCnt--;
            
            if(aCnt == bCnt) answer++;
        }
        
        return answer;
    }
}