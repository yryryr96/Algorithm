import java.util.*;
import java.io.*;

public class Main {

    static int t;
    static StringTokenizer st;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            visited = new int[10001];

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a,b);
        }
    }

    static void bfs(int original, int target) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(original);
        visited[original] = 1;

        while(!q.isEmpty()) {
            Integer now = q.poll();
            if (now == target) {
                System.out.println(visited[target] - 1);
                return;
            }

            int[] numList = {now/1000, (now/100)%10, (now/10)%10, now%10};
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) continue;

                    int temp = numList[i];
                    numList[i] = j;
                    int num = calc(numList);
                    numList[i] = temp;

                    if (visited[num] == 0 && check(num)) {
                        q.add(num);
                        visited[num] = visited[now] + 1;
//                        System.out.println("num = " + num);
                    }
                }
            }
        }
    }

    static int calc(int[] numList) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (int) Math.pow(10, 3-i) * numList[i];
        }
        return sum;
    }

    static boolean check(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i == 0) return false;
        }

        return true;
    }
}