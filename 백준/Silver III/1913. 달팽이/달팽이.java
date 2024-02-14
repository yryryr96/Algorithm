import java.util.*;
import java.io.*;

public class Main {

    static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    static int dir = 0;
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int findNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int y=0; int x=0;
        map = new int[n][n];
        go(n*n);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sb.append(map[i][j] + " ");
                if (map[i][j] == findNumber) {
                    y = i+1; x = j+1;
                }
            }
            sb.append("\n");
        }

        sb.append(y + " " + x);
        System.out.println(sb.toString());
    }

    public static void go(int num) {

        int i = 0; int j = 0;
        int ni;
        int nj;

        while (num > 0) {
//            System.out.println(num + " " + i + " " + j);
            map[i][j] = num;
            ni = i + di[dir];
            nj = j + dj[dir];
            if (0<=ni && ni<n && 0<=nj && nj<n && map[ni][nj] == 0) {
                i = ni;
                j = nj;
                num--;
            } else {
                dir = (dir+1)%4;
                if (num == 1) break;
            }
        }
    }
}