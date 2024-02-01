import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[computer+1];
        ArrayList<Integer>[] arr = new ArrayList[computer+1];
        for (int i = 1; i < computer+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i <n; i++) {
            String[] str = br.readLine().split(" ");
            int a = sToI(str[0]);
            int b = sToI(str[1]);

            arr[a].add(b);
            arr[b].add(a);
        }

        visited[1] = true;
        dfs(1, arr, visited);

        int answer = 0;
        for (int i = 2; i < computer+1; i++) {
            if (visited[i]) answer++;
        }

        System.out.println(answer);
    }
    public static int sToI (String str) {
        return Integer.parseInt(str);
    }

    public static void dfs(int i, ArrayList<Integer>[] arr, boolean[] visited) {

        ArrayList<Integer> graph = arr[i];
        for (int j : graph) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(j, arr, visited);
            }
        }
    }

}