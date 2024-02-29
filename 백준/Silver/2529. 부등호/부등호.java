import java.util.*;
import java.io.*;

public class Main {

    static HashMap<Character, Integer> map = new HashMap<>();
    static boolean[] visited;
    static String[] digits;
    static int n;
    static long MAX = Long.MIN_VALUE;
    static long MIN = Long.MAX_VALUE;
    static String ans1 = "0";
    static String ans2 = "0";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        digits = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            digits[i] = st.nextToken();
        }
        visited = new boolean[10];

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(0, String.valueOf(i), i);
            visited[i] = false;
        }

        System.out.println(ans1);
        System.out.println(ans2);
    }

    static void dfs(int depth, String v, long num) {

        if (depth == n) {
            if (MAX < Long.parseLong(v)) {
                MAX = Long.parseLong(v);
                ans1 = v;
            }

            if (MIN > Long.parseLong(v)) {
                MIN = Long.parseLong(v);
                ans2 = v;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (digits[depth].equals("<") && num < i) {
                    visited[i] = true;
                    dfs(depth+1, v + i, i);
                    visited[i] = false;
                } else if (digits[depth].equals(">") && num > i) {
                    visited[i] = true;
                    dfs(depth+1, v + i, i);
                    visited[i] = false;
                }
            }
        }
    }
}