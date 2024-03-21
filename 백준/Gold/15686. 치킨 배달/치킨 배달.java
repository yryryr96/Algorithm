import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int y, x;
        Pair (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n,m;
    static List<Pair> home = new ArrayList<>();
    static List<Pair> totalChickens = new ArrayList<>();
    static List<Pair[]> chickenComb = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) home.add(new Pair(i,j));
                else if (v == 2) totalChickens.add(new Pair(i,j));
            }
        }

        int ans = Integer.MAX_VALUE;
        getCombination(0,0,new Stack<Pair>());
        for (Pair[] comb : chickenComb) {
            ans = Math.min(getDistance(comb), ans);
        }

        System.out.println(ans);
    }

    static void getCombination(int depth, int start, Stack<Pair> stack) {

        if (depth == m) {

            Pair[] pairs = new Pair[m];
            for (int i = 0; i < m; i++) {
                pairs[i] = stack.get(i);
            }

            chickenComb.add(pairs);
            return;
        }

        for (int i = start; i < totalChickens.size(); i++) {

            stack.add(totalChickens.get(i));
            getCombination(depth+1, i+1, stack);
            stack.pop();
        }
    }

    static int getDistance(Pair[] chickens) {

        int distance = 0;
        for (Pair h : home) {
            int minDist = n*n;
            for (Pair c : chickens) {
                int dist = Math.abs(h.y - c.y) + Math.abs(h.x - c.x);
                minDist = Math.min(dist, minDist);
            }
            distance += minDist;
        }

        return distance;
    }
}