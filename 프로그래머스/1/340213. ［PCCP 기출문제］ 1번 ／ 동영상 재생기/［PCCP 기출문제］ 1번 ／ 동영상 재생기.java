import java.util.*;

class Solution {
    
    static int cur = 0;
    static int os = 0;
    static int oe = 0;
    static int vl = 0;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        cur = mTos(pos);
        os = mTos(op_start);
        oe = mTos(op_end);
        vl = mTos(video_len);
        
        for(String command : commands) {
           checkOpening();
           play(command);
            System.out.println(sTom(cur));
        }
        
        checkOpening();
        answer = sTom(cur);
        
        return answer;
    }
    
    static void checkOpening() {
        if (os <= cur && cur <= oe) {
            cur = oe;
        }
    }
    
    static void play(String command) {
        
        if (command.equals("next")) {
            cur += 10;
        } else {
            cur -= 10;
        }
        
        cur = (cur > vl ? vl : cur);
        
        if (cur < 10) {
            cur = 0;
        } else if (Math.abs(vl - cur) < 10) {
            cur = vl;
        } 
    }
    
    static Integer mTos(String minuteAndSecond) {
        
        String[] mAs = minuteAndSecond.split(":");
        Integer minute = Integer.parseInt(mAs[0]);
        Integer second = Integer.parseInt(mAs[1]);
        
        return (minute == 0) ? second : minute*60 + second;
    }
    
    static String sTom(Integer seconds) {
        
        Integer m = seconds / 60;
        Integer s = seconds % 60;
        
        String minute = (m < 10) ? "0" + m : Integer.toString(m);
        String second = (s < 10) ? "0" + s : Integer.toString(s);
        
        return minute + ":" + second;
    } 
}