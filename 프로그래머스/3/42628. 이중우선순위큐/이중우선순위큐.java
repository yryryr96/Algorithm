import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int iCnt = 0;
        int dCnt = 0;

        for (String operation : operations) {

            String[] str = operation.split(" ");
            String command = str[0];
            int num = Integer.parseInt(str[1]);

            if (command.equals("I")) {
                minQ.add(num);
                maxQ.add(num);
                iCnt++;
            }

            else if (iCnt > dCnt && command.equals("D")) {
                dCnt++;
                if (num == -1) {
                    Integer v = minQ.poll();
                    maxQ.remove(v);

                } else {
                    Integer v = maxQ.poll();
                    minQ.remove(v);
                }
            }
        }

        int[] answer;
        if (iCnt == dCnt) {
            answer = new int[]{0,0};
        } else {
            answer = new int[]{maxQ.peek(), minQ.peek()};
        }

        return answer;
    }
}