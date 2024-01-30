class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        String id = id_pw[0];
        String pw = id_pw[1];
        int temp = 0;
        
        for (String[] data : db) {
            if (id.equals(data[0]) && pw.equals(data[1])) {
                answer = "login";
                break;
            } else if(id.equals(data[0])) {
                temp = 1;
            }
        }
        
        if (answer.isEmpty() && temp == 1) {
            answer = "wrong pw";
        } else if(answer.isEmpty() && temp == 0) {
            answer = "fail";
        }
        return answer;
    }
}