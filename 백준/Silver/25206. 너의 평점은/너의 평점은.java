import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rank = {"A+","A0","B+","B0","C+","C0","D+","D0","F"};
        double[] score = {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0,0};
        double sum = 0 , sum_score = 0 ;

        for (int i = 0; i <20 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double t = Double.parseDouble(st.nextToken());
            String scoreTemp = st.nextToken();

            for (int j = 0; j <9 ; j++) {
                if (scoreTemp.equals(rank[j])) {
                    sum_score += t;
                    sum += t*score[j];
                    break;
                }
            }
        }
        System.out.println(sum/sum_score);
    }
}