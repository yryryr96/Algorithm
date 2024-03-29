import java.io.*;
import java.util.*;

public class Main {

    static int n,m,r;
    static int[][] arr;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        r = stoi(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void rotate() {

        for (int k = 0; k < Math.min(n,m) / 2; k++) {

            int y = k;
            int x = k;

            int temp = arr[y][x];
            int idx = 0;
            while(idx < 4) {

                int ny = y + dy[idx];
                int nx = x + dx[idx];

                if (ny <= n-1-k && nx <= m-1-k && ny >= k && nx >= k) {
                    arr[y][x] = arr[ny][nx];
                    y = ny;
                    x = nx;
                } else {
                    idx++;
                }
            }

            arr[k+1][k] = temp;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}