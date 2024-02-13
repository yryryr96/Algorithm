
import java.util.*;
import java.io.*;

public class Main {

    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[][] board = new String[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = board[i][j];
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);

                for (int k = 0; k < 4; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];

                    if (0<=ni && ni<n && 0<=nj && nj<n && !board[ni][nj].equals(s)) {
                        String ns = board[ni][nj];
//                        System.out.println("s = " + s);
//                        System.out.println("ns = " + ns);
//                        System.out.println("k = " + k);
                        board[ni][nj] = s;
                        board[i][j] = ns;
                        ans = Math.max(count(board), ans);
//                        System.out.println("count(board) = " + count(board));
                        board[i][j] = s;
                        board[ni][nj] = ns;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static int count(String[][] map) {

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int cntR = 1;
                int cntC = 1;
                String s = map[i][j];
                int y = i+1;
                int x = j+1;
                while (y < n) {
                    if (map[y][j].equals(s)) {
                        cntR++;
                        y++;
                    } else {
                        break;
                    }
                }

                while (x < n) {
                    if (map[i][x].equals(s)) {
                        cntC++;
                        x++;
                    } else {
                        break;
                    }
                }

                cnt = Math.max(Math.max(cntR,cntC), cnt);
            }
        }

        return cnt;
    }
}
