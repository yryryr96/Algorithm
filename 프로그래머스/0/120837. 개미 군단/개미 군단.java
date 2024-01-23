class Solution {
    public int solution(int hp) {
        int answer = 0;
        int one;
        int two;
        int three;
        
        one = hp/5;
        answer += (one);
        hp -= one*5;
        two = hp/3;
        answer += (two);
        hp-= two*3;
        answer += hp;
        
        return answer;
    }
}