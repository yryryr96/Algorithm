class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0}; // x,y 좌표
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        // u,d,r,l
        int x = board[0];
        int y = board[1];
        int w = 0;
        int h = 0;
        for (String command : keyinput) {
            if (command.equals("up") && h+1 <= y/2) {
                h++;
            } else if(command.equals("down") && h-1 >= -y/2) {
                h--;
            } else if(command.equals("left") && w-1 >= -x/2) {
                w--;
            } else if(command.equals("right") && w+1 <= x/2) {
                w++;
            }
        }
        answer[0] = w;
        answer[1] = h;
        return answer;
    }
}