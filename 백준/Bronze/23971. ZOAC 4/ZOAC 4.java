import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = stoi(st.nextToken());
        int W = stoi(st.nextToken());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int rowCount = H / (N+1);
        int colCount = W / (M+1);

        int rowRemain = H % (N + 1);
        int colRemain = W % (M + 1);

        if (rowRemain != 0 && colRemain != 0) {
            rowCount++;
            colCount++;
        } else if(rowRemain != 0 && colRemain == 0) {
            rowCount++;
        } else if(rowRemain == 0 && colRemain != 0) {
            colCount++;
        }

        int answer = rowCount * colCount;
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

