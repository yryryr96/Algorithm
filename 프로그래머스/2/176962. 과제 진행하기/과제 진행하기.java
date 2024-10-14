import java.util.*;
class Solution {
    
    static List<String> answers = new ArrayList<>();
    public String[] solution(String[][] plans) {
        
        
        for(String[] plan : plans) {
            String[] s = plan[1].split(":");
            int h = Integer.parseInt(s[0]) * 60;
            int m = Integer.parseInt(s[1]);
            
            plan[1] = Integer.toString(h+m);
        }
        
        Arrays.sort(plans, (a,b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        
        Queue<String[]> waitingQ = new LinkedList<>();
        
        for(int i = 0; i < plans.length; i++) {
            waitingQ.add(plans[i]);
        }
        
        Stack<String[]> stopQ = new Stack<>();
        String[] cur = waitingQ.poll();
        int curTime = Integer.parseInt(cur[1]);
        
        while(answers.size() < plans.length) {
            
            String subject = cur[0];
            int st = Integer.parseInt(cur[1]);
            int rt = Integer.parseInt(cur[2]);
            // System.out.println("s = " + subject + ", curTime = " + curTime);
            if (!waitingQ.isEmpty()) {
                String[] next = waitingQ.peek();
                String nSubject = next[0];
                int nst = Integer.parseInt(next[1]);
                int nrt = Integer.parseInt(next[2]);
                
                if (st + rt >= nst) {
                    
                    if(st + rt > nst) {
                        stopQ.add(new String[]{subject, Integer.toString(st+rt-nst)});
                    } else {
                        answers.add(subject);
                    }
                    
                    curTime = nst;
                    cur = waitingQ.poll();
                    continue;
                }
            }
            
            curTime = st + rt;
            answers.add(subject);
            if (!waitingQ.isEmpty()) {
                String[] next = waitingQ.peek();
                int nst = Integer.parseInt(next[1]);
                if(curTime == nst) {
                    cur = waitingQ.poll();
                    continue;
                } else if(stopQ.isEmpty() && nst > curTime) {
                    curTime = nst;
                    cur = waitingQ.poll();
                    continue;
                }
            }
            
            if(!stopQ.isEmpty()) {
                String[] next = stopQ.pop();
                cur = new String[]{next[0], Integer.toString(curTime), next[1]};
            }
        }
        
        String[] answer = new String[answers.size()];
        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}