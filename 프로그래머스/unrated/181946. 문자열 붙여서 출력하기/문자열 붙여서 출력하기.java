import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        System.out.print(str1+str2);     
    }
}