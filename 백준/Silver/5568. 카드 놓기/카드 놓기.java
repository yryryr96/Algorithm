import java.io.*;
import java.util.*;

public class Main {

    static int n,k;
    static HashSet<String> set =  new HashSet<>();
    static String[] cards;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        k = stoi(br.readLine());
        cards = new String[n];
        visited  = new boolean[n];

        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(1, cards[i]);
            visited[i] = false;
        }

        System.out.println(set.size());
    }

    static void dfs(int depth, String number) {

        if (depth == k) {
            set.add(number);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, number + cards[i]);
            visited[i] = false;
        }
    }
    
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

