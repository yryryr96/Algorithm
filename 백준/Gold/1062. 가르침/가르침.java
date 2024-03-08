import java.io.*;
import java.util.*;

public class Main {

    static int n,k;
    static HashSet<Character> chars = new HashSet<>();
    static List<String> words = new ArrayList<>();
    static boolean[] visited = new boolean[26];
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            cutting(word);
        }

        if (k == 26) ans = n;
        else if (k < 5) ans = 0;
        else if (chars.size() <= k-5) ans = n;
        else {
            k-=5;
            visited['a'-97] = visited['n'-97] = visited['t'-97] = visited['i'-97] = visited['c'-97] = true;
            dfs(0,-1);
        }

        System.out.println(ans);
    }

    static void dfs(int depth, int idx) {

        if (depth == k) {
            ans = Math.max(ans, calc());
            return;
        }

        for (int i = idx+1; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i);
                visited[i] = false;
            }
        }
    }

    static int calc() {

        int cnt = 0;
        for (String word : words) {
            boolean isContain = true;
            for (int i = 0; i < word.length(); i++) {
                int idx = (int) (word.charAt(i) - 97);
                if (!visited[idx]) {
                    isContain = false;
                    break;
                }
            }

            if (isContain) {
                cnt++;
            }
        }

        return cnt;
    }

    static void cutting(String word) {
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') continue;
            chars.add(c);
            sb.append(c);
        }

        char[] chArr = sb.toString().toCharArray();
        words.add(new String(chArr));
    }
}