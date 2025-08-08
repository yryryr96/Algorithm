
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] info = new int[N][2];
        int[] grades = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = stoi(st.nextToken());
            info[i][1] = stoi(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int k = 0;
            for (int j = 0; j < N; j++) {

                if (i == j) continue;

                int[] A = info[i];
                int[] B = info[j];

                if (A[0] < B[0] && A[1] < B[1]) {
                    k++;
                }
            }

            grades[i] = k + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(grades[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
