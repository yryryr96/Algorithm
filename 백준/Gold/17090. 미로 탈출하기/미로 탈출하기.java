import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static boolean[][] visited, dp;
    static String[][] commands;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static HashMap<String, Integer> commandMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        initCommandMap();

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        dp = new boolean[N][M];
        visited = new boolean[N][M];
        commands = new String[N][M];

        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean dfs(int y, int x) {

        String command = commands[y][x];
        Integer d = commandMap.get(command);
        visited[y][x] = true;
        int ny = y + dy[d];
        int nx = x + dx[d];

        if (isInRange(ny, nx) && visited[ny][nx]) {
            dp[y][x] = dp[ny][nx];
        }

        else if (isInRange(ny,nx) && !visited[ny][nx]) {
            dp[y][x] = dfs(ny, nx);
        }

        else if (!isInRange(ny, nx)) {
            dp[y][x] = true;
        }

        return dp[y][x];
    }

    static void initCommandMap() {
        commandMap.put("U", 0);
        commandMap.put("R", 1);
        commandMap.put("D", 2);
        commandMap.put("L", 3);
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
