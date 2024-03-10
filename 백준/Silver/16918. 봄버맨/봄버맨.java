import java.io.*;
import java.util.*;

public class Main {

    static int r,c,n;
    static char[][] map;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static List<int[]> q = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solve(n);
    }

    static void print() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void solve(int n) {

        if (n==1) {
            print();
        }
        else if (n%2 == 0) {
            fill();
            print();
        } else if (n%4 == 1) {
            fill();
            bomb();
            fill();
            bomb();
            print();
        } else if (n%4 == 3) {
            fill();
            bomb();
            print();
        }
    }

    static void init(char[][] pattern) {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                pattern[i][j] = map[i][j];
            }
        }
    }
    static void bomb() {

        for (int[] pair : q) {
            int i = pair[0];
            int j = pair[1];

//            System.out.println("i = " + i + " j = " + j);
            map[i][j] = '.';

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (0 > ni || 0 > nj || ni >= r || nj >= c) continue;
                map[ni][nj] = '.';
            }
        }
    }

    static void fill() {

        q = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') q.add(new int[]{i,j});
                else if (map[i][j] == '.') map[i][j] = 'O';
            }
        }
    }
}