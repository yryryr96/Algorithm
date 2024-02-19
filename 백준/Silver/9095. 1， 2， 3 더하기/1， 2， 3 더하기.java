import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static int cnt;
    static int[] numbers = new int[]{1,2,3};

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            play();
        }
    }

    public static void play() throws IOException {

        int target = Integer.parseInt(br.readLine());
        cnt = 0;
        for (int number : numbers) {
            dfs(target, number);
        }
        System.out.println(cnt);
    }

    public static void dfs(int target, int sum) {

        if (sum > target) return;
        if (target == sum) {
            cnt++;
        }

        for (int number : numbers) {
            dfs(target, sum+number);
        }
    }
}