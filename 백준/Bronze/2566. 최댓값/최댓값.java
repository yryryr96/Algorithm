import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int[] point = {1,1};

        for (int i = 0; i <9 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <9 ; j++) {
                int check = Integer.parseInt(st.nextToken());
                if (max < check){
                    max = check;
                    point[0] = i+1;
                    point[1] = j+1;
                }
            }
        }
        System.out.println(max);
        for (int i = 0; i <2 ; i++) {
            System.out.print(point[i] + " ");
        }
    }
}