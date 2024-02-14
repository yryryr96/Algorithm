import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {

            StringBuilder sb = new StringBuilder();
            int lower = 0;
            int upper = 0;
            int num = 0;
            int space = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c)) upper++;
                else if (Character.isLowerCase(c)) lower++;
                else if (c == ' ') space++;
                else if (Character.isDigit(c)) num ++;
            }

            sb.append(lower).append(" ").append(upper).append(" ").append(num).append(" ").append(space);
            System.out.println(sb.toString());
        }
    }
}
