import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[][] board;
    static int ROW, COL;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        R = stoi(st.nextToken());
        board = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                board[row][col] = stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int command = stoi(st.nextToken());
            rotate(command);
        }

        StringBuilder sb = new StringBuilder();
        ROW = board.length;
        COL = board[0].length;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                sb.append(board[row][col] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void rotate(int command) {
        ROW = board.length;
        COL = board[0].length;

        switch(command){
            case 1 -> rotate1();
            case 2 -> rotate2();
            case 3 -> rotate3();
            case 4 -> rotate4();
            case 5 -> rotate5();
            case 6 -> rotate6();
        }
    }

    // 상하 반전
    static void rotate1() {
        int[][] nextBoard = new int[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                nextBoard[row][col] = board[ROW-1-row][col];
            }
        }

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = nextBoard[row][col];
            }
        }
    }

    // 좌우 반전
    static void rotate2() {
        int[][] nextBoard = new int[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                nextBoard[row][col] = board[row][COL-1-col];
            }
        }

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = nextBoard[row][col];
            }
        }
    }

    // 오른쪽 90도 회전
    static void rotate3() {
        int[][] nextBoard = new int[COL][ROW];
        for (int row = 0; row < COL; row++) {
            for (int col = 0; col < ROW; col++) {
                nextBoard[row][col] = board[ROW-1-col][row];
            }
        }

        board = nextBoard;
    }

    // 왼쪽 90도 회전
    static void rotate4() {
        int[][] nextBoard = new int[COL][ROW];
        for (int row = 0; row < COL; row++) {
            for (int col = 0; col < ROW; col++) {
                nextBoard[row][col] = board[col][COL-1-row];
            }
        }

        board = nextBoard;
    }

    //
    static void rotate5() {
        int[][] group1 = new int[ROW/2][COL/2];
        int[][] group2 = new int[ROW/2][COL/2];
        int[][] group3 = new int[ROW/2][COL/2];
        int[][] group4 = new int[ROW/2][COL/2];

        for (int row = 0; row < ROW/2; row++) {
            for (int col = 0; col < COL/2; col++) {
                group1[row][col] = board[row][col];
                group2[row][col] = board[row][col+COL/2];
                group3[row][col] = board[row+ROW/2][col+COL/2];
                group4[row][col] = board[row+ROW/2][col];
            }
        }

        for (int row = 0; row < ROW/2; row++) {
            for (int col = 0; col < COL/2; col++) {
                board[row][COL/2 + col] = group1[row][col];
                board[ROW/2 + row][COL/2 + col] = group2[row][col];
                board[ROW/2 + row][col] = group3[row][col];
                board[row][col] = group4[row][col];
            }
        }
    }

    static void rotate6() {
        int[][] group1 = new int[ROW/2][COL/2];
        int[][] group2 = new int[ROW/2][COL/2];
        int[][] group3 = new int[ROW/2][COL/2];
        int[][] group4 = new int[ROW/2][COL/2];

        for (int row = 0; row < ROW/2; row++) {
            for (int col = 0; col < COL/2; col++) {
                group1[row][col] = board[row][col];
                group2[row][col] = board[row][col+COL/2];
                group3[row][col] = board[row+ROW/2][col+COL/2];
                group4[row][col] = board[row+ROW/2][col];
            }
        }

        for (int row = 0; row < ROW/2; row++) {
            for (int col = 0; col < COL/2; col++) {
                board[row+ROW/2][col] =  group1[row][col];
                board[row+ROW/2][col+COL/2] =  group4[row][col];
                board[row][COL/2+col] = group3[row][col];
                board[row][col] = group2[row][col];
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

