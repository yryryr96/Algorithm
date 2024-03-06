import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        calculation(0,n);
        System.out.println(sb.toString());
    }

    static void calculation(int number, int n) {

        if (n == 0) {
            sb.append(number).append("\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            int num = number*10 + i;
            if (isPrime(num)) calculation(num, n-1);
        }
    }

    static boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i==0) return false;
        }

        return true;
    }
}