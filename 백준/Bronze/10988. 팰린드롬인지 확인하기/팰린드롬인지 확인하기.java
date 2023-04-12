import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ans = br.readLine();
        StringBuffer sb = new StringBuffer(ans);
        String check = sb.reverse().toString();
        if(ans.equals(check)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}