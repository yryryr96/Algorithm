import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 10001;

        if (m==1) m+=1;
        for (int i = m; i <n+1 ; i++) {
            int temp = 1;
            for (int j = 2; j < i; j++) {
                if (i%j==0){
                    temp = 0;
                    break;
                }

            }
            if (temp==1){
                sum+=i;
                if (min>i) min=i;
            }

        }
        if (sum!=0) {
            System.out.println(sum);
            System.out.println(min);
        }else {
            System.out.println(-1);
        }
    }
}