import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int size = answers.length;
        
        int[] answerCnt = new int[]{0,0,0};
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] three = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        List<int[]> arr = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
            
            int ans = answers[i];
            
            if(one[i%one.length] == ans) {
                answerCnt[0]++;
            }
            if (two[i%two.length] == ans) {
                answerCnt[1]++;                
            }
            if (three[i%three.length] == ans) {
                answerCnt[2]++;                
            }
        }
        
        int maxValue = 0;
        int cnt = 0;
        
        for (int i = 0; i < 3; i++) {
            
            int v = answerCnt[i];
            
            arr.add(new int[]{i+1, v});
            if (maxValue < v) {
                maxValue = v;
                cnt = 1;
            } else if (maxValue == v) {
                cnt++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if (answerCnt[i] == maxValue) {
                ans.add(i+1);
            }
        }
        
        int[] a = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        
        return a;
    }
}