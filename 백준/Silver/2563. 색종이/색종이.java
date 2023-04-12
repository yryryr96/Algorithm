import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[101][101];

        for (int t = 0; t <n ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = y; i < y+10 ; i++) {
                for (int j = x; j < x+10 ; j++) {
                    graph[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <101 ; i++) {
            for (int j = 0; j <101 ; j++) {
                if (graph[i][j] == 1) ans += 1;
            }
        }
        System.out.println(ans);
    }
}