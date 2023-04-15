import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n+1 ; i++) {
            q.addFirst(i);
        }

        while (q.size() != 1){
            q.removeLast();
            q.addFirst(q.removeLast());
        }
        System.out.println(q.getFirst());
    }
}