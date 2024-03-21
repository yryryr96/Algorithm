import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int n;
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        up(board);
//        right(board);
//        up(board);
//        left(board);
//        up(board);
//
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }

        for (int i = 1; i <= 4; i++) {
            move(0, board, i);
        }

        System.out.println(ans);
    }

    static void move(int depth, int[][] map, int func) {

        if (depth == 5) {
            // 최대 값 갱신

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(map[i][j], ans);
                }
            }
            return;
        }

        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[i][j];
            }
        }

        if (func == 1) {
            up(temp);
        } else if(func == 2) {
            right(temp);
        } else if(func == 3) {
            down(temp);
        } else left(temp);

        for (int i = 1; i <= 4; i++) {
            move(depth+1, temp, i);
        }

    }

    static void up(int[][] map) {

        boolean[][] visited = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] == 0) continue;

                int v = map[i][j];
                int r = i;

                while(r > 0) {
                    if (map[r-1][j] == 0) {
                        map[r][j] = 0;
                        map[r-1][j] = v;
                        r--;
                    }
                    else if(map[r-1][j] != v || visited[r-1][j]) break;
                    else if(map[r-1][j] == v) {
                        map[r][j] = 0;
                        map[r-1][j] = 2*v;
                        visited[r-1][j] = true;
                        break;
                    }
                }
            }
        }
    }

    static void down(int[][] map) {

        boolean[][] visited = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = n-1; i >= 0; i--) {
                if (map[i][j] == 0) continue;

                int v = map[i][j];
                int r = i;

                while(r < n-1) {
                    if (map[r+1][j] == 0) {
                        map[r][j] = 0;
                        map[r+1][j] = v;
                        r++;
                    }
                    else if(map[r+1][j] != v || visited[r+1][j]) break;
                    else if(map[r+1][j] == v) {
                        map[r][j] = 0;
                        map[r+1][j] = 2*v;
                        visited[r+1][j] = true;
                        break;
                    }
                }
            }
        }
    }

    static void left(int[][] map) {

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;

                int v = map[i][j];
                int c = j;

                while(c > 0) {
                    if (map[i][c-1] == 0) {
                        map[i][c] = 0;
                        map[i][c-1] = v;
                        c--;
                    }
                    else if(map[i][c-1] != v || visited[i][c-1]) break;
                    else if(map[i][c-1] == v) {
                        map[i][c] = 0;
                        map[i][c-1] = 2*v;
                        visited[i][c-1] = true;
                        break;
                    }
                }
            }
        }
    }

    static void right(int[][] map) {

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                if (map[i][j] == 0) continue;

                int v = map[i][j];
                int c = j;

                while(c < n-1) {
                    if (map[i][c+1] == 0) {
                        map[i][c] = 0;
                        map[i][c+1] = v;
                        c++;
                    }
                    else if(map[i][c+1] != v || visited[i][c+1]) break;
                    else if(map[i][c+1] == v) {
                        map[i][c] = 0;
                        map[i][c+1] = 2*v;
                        visited[i][c+1] = true;
                        break;
                    }
                }
            }
        }
    }
}