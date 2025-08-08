import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = stoi(br.readLine());

        int n = 1;
        int cnt = 0;
        while (true) {

            for (int i = 1; i <= n; i++) {
                cnt++;
                if (cnt == X) {
                    if (n % 2 == 0) {
                        System.out.println(i + "/" + (n + 1 - i));
                    } else {
                        System.out.println((n + 1 - i) + "/" + i);
                    }
                    return;
                }
            }

            n++;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
