import java.util.*;
import java.io.*;

class Solution {
    
    static HashMap<String, Integer> friendsIdx = new HashMap<>();
    static int[] giftScore;
    static int[][] giftInfo;
    static int[] nextGiftInfo;
    static int n;
    
    public int solution(String[] friends, String[] gifts) {
        
        n = friends.length;
        
        giftScore = new int[n];
        giftInfo = new int[n][n];
        nextGiftInfo = new int[n];
        for (int i = 0; i < n; i++) {
            friendsIdx.put(friends[i], i);
        }
        
        giftInfoInit(gifts);
        giftScoreInit();
        getNextGiftInfo();
        
        return getAnswer();
    }
    
    static int getAnswer() {
        
        int ans = 0;
        for (int i=0; i < n; i++) {
            ans = Math.max(ans, nextGiftInfo[i]);
        }
        
        return ans/2;
    }
    
    static void giftInfoInit(String[] gifts) {
        
        for (String gift : gifts) {
            String[] toFrom = gift.split(" ");
            giftInfo[friendsIdx.get(toFrom[0])][friendsIdx.get(toFrom[1])]++;
        }
    }
    
    static void getNextGiftInfo() {
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                
                int temp;
                if(giftInfo[i][j] != 0 || giftInfo[j][i] != 0) {
                    
                    if (giftInfo[i][j] == giftInfo[j][i]) {
                        if (giftScore[i] == giftScore[j]) continue;
                        temp = giftScore[i] > giftScore[j] ? i : j;
                    } else {
                        temp = giftInfo[i][j] > giftInfo[j][i] ? i : j;
                    }
                    
                } else {
                    if (giftScore[i] == giftScore[j]) continue;
                    temp = giftScore[i] > giftScore[j] ? i : j;
                }
                
                nextGiftInfo[temp] ++;
            }
        }
    }
    
    static void giftScoreInit() {
        
        for (int i = 0; i < n; i++) {
            giftScore[i] = getGiftScore(i);
        }
    }
    
    static int getGiftScore(int number) {
        
        int give = 0;
        int receive = 0;
        for (int i = 0; i < n; i++) {
            if (i == number) continue;
            give += giftInfo[number][i];
            receive += giftInfo[i][number];
        }
        
        return give - receive;
    }
}