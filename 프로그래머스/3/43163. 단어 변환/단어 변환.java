import java.util.*;
class Solution {
    static int[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        visited = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 0 && check(begin, words[i])) {
                visited[i] = 1;
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            Integer idx = q.poll();
            if (words[idx].equals(target)) {
                answer = visited[idx];
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i] == 0 && check(words[idx], words[i])) {
                    visited[i] = visited[idx] + 1;
                    q.offer(i);
                }
            }
        }
        return answer;
    }

    public static boolean check(String begin, String candidate) {

        if (begin.length() != candidate.length()) {
            return false;
        }

        int l = begin.length();
        int temp = 0;

        for (int i = 0; i < l; i++) {
            if (begin.charAt(i) != candidate.charAt(i)) temp++;
            if (temp > 1) return false;
        }

        return temp == 1;
    }
}