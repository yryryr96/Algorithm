import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[100000];
        int[] b = new int[100000];

        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");
        for (int i = 0; i < 100000; i++) {
            a[i] = stoi(s1[i]);
            b[i] = stoi(s2[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(a[i] & b[i]);
        }

        sb.append("\n");
        for (int i = 0; i < 100000; i++) {
            sb.append(a[i] | b[i]);
        }
        sb.append("\n");
        for (int i = 0; i < 100000; i++) {
            sb.append(a[i] ^ b[i]);
        }
        sb.append("\n");
        for (int i = 0; i < 100000; i++) {
            sb.append(a[i] ^ 1);
        }

        sb.append("\n");
        for (int i = 0; i < 100000; i++) {
            sb.append(b[i]^1);
        }
        System.out.println(sb.toString());
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}