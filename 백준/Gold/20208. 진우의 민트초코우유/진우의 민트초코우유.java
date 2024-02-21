import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int h;
    static String[][] map;
    static List<Pair> mint = new ArrayList<>();
    static int ans = 0;
    static int s,e;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new String[n][n];

        
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("2")) {
                    mint.add(new Pair(i,j));
                } else if (map[i][j].equals("1")) {
                  s = i; e = j;
                }
            }
        }

        dfs(s, e, m, 0);
        System.out.println(ans);

    }

    static void dfs(int i, int j, int hp, int cnt) {

        if ((Math.abs(i-s) + Math.abs(j-e)) <= hp) ans = Math.max(ans, cnt);
        if (ans == mint.size()) return;

        for (Pair p : mint) {
            int ni = p.y;
            int nj = p.x;

            if (map[ni][nj].equals("2")) {
                int distance = Math.abs(i-ni) + Math.abs(j-nj);
                if (distance <= hp) {
                    map[ni][nj] = "0";
                    dfs(ni, nj, hp - distance + h, cnt+1);
                    map[ni][nj] = "2";
                }
            }
        }
    }

    static class Pair {
        int y,x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}