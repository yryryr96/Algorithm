import java.io.*;
import java.util.*;

public class Main {

    static int n,m,x,y,k;
    static int[][] map;
    static int[] command;
    static int top,bottom,left,right,north,south;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        top = bottom = left = right = north = south = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        command = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            move(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb.toString());
    }

    static void move(int cmd) {

        int ny = y + dy[cmd-1];
        int nx = x + dx[cmd-1];

        if (0 > ny || 0 > nx || ny >= n || nx >= m) return;
        y = ny; x = nx;

        boolean tmp = false;
        if (map[y][x] == 0) tmp = true;
        //위로
        if (cmd == 3) {
            int temp = north;
            north = top;
            top = south;
            south = bottom;

            if (tmp) {
                bottom = temp;
                map[y][x] = bottom;
            } else {
                bottom = map[y][x];
                map[y][x] = 0;
            }

        }
        //아래로
        else if (cmd == 4) {
            int temp = south;
            south = top;
            top = north;
            north = bottom;

            if (tmp) {
                bottom = temp;
                map[y][x] = bottom;
            } else {
                bottom = map[y][x];
                map[y][x] = 0;
            }
        }
        //왼쪽
        else if (cmd == 2) {
            int temp = left;
            left = top;
            top = right;
            right = bottom;

            if (tmp) {
                bottom = temp;
                map[y][x] = bottom;
            } else {
                bottom = map[y][x];
                map[y][x] = 0;
            }
        }
        //오른쪽
        else if (cmd == 1) {
            int temp = right;
            right = top;
            top = left;
            left = bottom;

            if (tmp) {
                bottom = temp;
                map[y][x] = bottom;
            } else {
                bottom = map[y][x];
                map[y][x] = 0;
            }
        }
        sb.append(top).append("\n");
    }
}