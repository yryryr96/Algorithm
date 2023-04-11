import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] num = new int[31];
        for (int i = 0; i <28 ; i++) {
            int n = Integer.parseInt(br.readLine());
            num[n] = 1;
        }

        for (int i = 1; i < 31 ; i++) {
            if (num[i] != 1 ) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}