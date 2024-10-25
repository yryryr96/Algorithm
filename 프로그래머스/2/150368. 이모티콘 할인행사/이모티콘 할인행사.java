import java.util.*;

class Solution {
    
    static int n;
    static List<List<Integer>> comb = new ArrayList<>();
    static int signUpCnt = 0;
    static int totalMoney = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] answer = {};

        n = emoticons.length;
        getComb(0, new ArrayList<>());
        
        for(List<Integer> combi : comb) {
            simulate(users, emoticons, combi);
        }

        answer = new int[]{signUpCnt, totalMoney};
        
        return answer;
    }
    
    static void simulate(int[][] users, int[] emoticons, List<Integer> combination) {
        
        int cnt = 0, money = 0;
        
        for(int[] user : users) {
            
            int ratio = user[0];
            int limit = user[1];
            // System.out.println("=============");
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int emoticonRatio = combination.get(i);
                int emoticonPrice = emoticons[i];
                                
                if(emoticonRatio < ratio) continue;
                
                emoticonPrice = emoticonPrice * (100 - emoticonRatio) / 100;
                // System.out.println("er = " + emoticonRatio + " , ep = " + emoticonPrice);
                sum += emoticonPrice;                
            }
            
            if (sum >= limit) {
                cnt++;
            } else {
                money += sum;
            }
        }
        
        if (cnt > signUpCnt) {
            signUpCnt = cnt;
            totalMoney = money;
        } else if (cnt == signUpCnt && totalMoney < money) {
            totalMoney = money;
        }
    }
    
    static void getComb(int depth, List<Integer> arr) {
        
        if(depth == n) {
            comb.add(arr);
            return;
        }
        
        for(int i = 10; i <= 40; i+=10) {
            List<Integer> temp = new ArrayList<>(arr);
            temp.add(i);
            getComb(depth + 1, temp);
        }
    }
}