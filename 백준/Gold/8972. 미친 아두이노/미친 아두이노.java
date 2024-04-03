import java.io.*;
import java.util.*;

public class Main {

    static int R,C;
    static char[][] board;
    static int[] dy = {-1,1,1,1,0,0,0,-1,-1,-1};
    static int[] dx = {-1,-1,0,1,-1,0,1,-1,0,1};
    static class Node {
        int y,x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Node jongsu;
    static int[][] visited;
    static List<Node> crazyRobots = new ArrayList<>();
    static boolean temp = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'I') jongsu = new Node(i,j);
                else if (board[i][j] == 'R') {
                    crazyRobots.add(new Node(i,j));
                    visited[i][j]++;
                }
            }
        }

        String[] cmd = br.readLine().split("");
        for (int i = 0; i < cmd.length; i++) {
            int command = Integer.parseInt(cmd[i]);
            if (!jongsuMove(i+1, command)) break;
            if (!robotMove(i+1)) break;
        }

        if (temp) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i == jongsu.y && j == jongsu.x) board[i][j] = 'I';
                    else board[i][j] = '.';
                }
            }

            for (Node crazyRobot : crazyRobots) {
                board[crazyRobot.y][crazyRobot.x] = 'R';
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
        }
    }


    static boolean jongsuMove(int idx, int k) {
        jongsu.y = jongsu.y + dy[k];
        jongsu.x = jongsu.x + dx[k];
        if (visited[jongsu.y][jongsu.x] == 1) {
            System.out.println("kraj " + idx);
            temp = false;
            return false;
        }
        return true;
    }

    static boolean robotMove(int idx) {

        List<Node> Nodes = new ArrayList<>();
        visited = new int[R][C];

        for (Node crazyRobot : crazyRobots) {
            Node nextNode = getNextNode(crazyRobot);
            if (nextNode.y == jongsu.y && nextNode.x == jongsu.x) {
                System.out.println("kraj " + idx);
                temp = false;
                return false;
            }
            visited[nextNode.y][nextNode.x]++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] == 1) {
                    Nodes.add(new Node(i,j));
                }
            }
        }

        crazyRobots = Nodes;
        return true;
    }

    static Node getNextNode(Node cur) {

        int dist = Integer.MAX_VALUE;
        int k = 1;
        for (int i = 1; i <= 9; i++) {
            if (i == 5) continue;
            int ny = cur.y + dy[i];
            int nx = cur.x + dx[i];
            if (dist > Math.abs(ny - jongsu.y) + Math.abs(nx - jongsu.x)) {
                dist = Math.abs(ny - jongsu.y) + Math.abs(nx - jongsu.x);
                k = i;
            }
        }

        cur.y = cur.y + dy[k];
        cur.x = cur.x + dx[k];
        return cur;
    }
}