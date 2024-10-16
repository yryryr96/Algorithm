class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int attackIdx = 0;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int curTime = 0;
        int curHp = health;
        while(curHp > 0 && attackIdx < attacks.length) {
            // System.out.println("time = " + curTime);
            int attackTime = attacks[attackIdx][0];
            int damage = attacks[attackIdx][1];
            
            boolean temp = true;
            for(int i = 0; i < t; i++) {
                curTime++;
                
                if (curTime == attackTime) {
                    curHp -= damage;
                    attackIdx++;
                    temp = false;
                    break;
                }
                
                curHp = Math.min(health, curHp + x);
            }
            
            if (curHp <= 0) break;
            
            if(temp) {
                curHp += y;
                curHp = Math.min(health, curHp);
            }
            
            System.out.println("time = " + curTime + " hp = " + curHp);
        }
        
        System.out.println("resTime = " + curTime + " resHp = " + curHp);
        answer = (curHp <= 0 ? -1 : curHp);
               
        return answer;
    }
}