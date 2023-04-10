import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        for (int i = 0; i < 9 ; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int max_num = 0;
        int max_idx = 0;
        for (int i = 0; i <9 ; i++) {
            if (num[i] > max_num) {
                max_num = num[i];
                max_idx = i + 1;
            }
        }
        System.out.println(max_num);
        System.out.println(max_idx);
    }
}