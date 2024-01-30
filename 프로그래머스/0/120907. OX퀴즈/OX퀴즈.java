class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i=0; i<quiz.length; i++) {
            answer[i] = calculate(quiz[i]);
        }
        return answer;
    }
    
    public static String calculate(String str) {

        String[] strList = str.split(" ");
        int a = Integer.parseInt(strList[0]);
        int b = Integer.parseInt(strList[2]);
        int c = Integer.parseInt(strList[4]);

        if (strList[1].equals("+") && a+b==c) {
            return "O";
        } else if (strList[1].equals("-") && a-b==c) {
            return "O";
        } else {
            return "X";
        }
    }
}