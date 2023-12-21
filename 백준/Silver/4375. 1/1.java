import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int cnt = 1;
            int base = 1;
            String input = br.readLine();
            if (input == null) break;

            int number = Integer.parseInt(input);
            while((base = base % number) != 0) {

                cnt ++;
                base = base*10 + 1;
            }
            System.out.println(cnt);
        }
    }
}