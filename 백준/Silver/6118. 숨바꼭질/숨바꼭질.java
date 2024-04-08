import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int ansNum, ansDist, ansCnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();
        System.out.println(getAnswer());
    }

    static String getAnswer() {

        for (int i = N; i > 0 ; i--) {
            if (visited[i] == ansDist) {
                ansCnt++;
                ansNum = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ansNum + " " + (ansDist-1) + " " + ansCnt);
        return sb.toString();
    }

    static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        visited = new int[N+1];

        q.add(1);
        visited[1] = 1;
        while(!q.isEmpty()) {

            int now = q.poll();
            ansDist = Math.max(visited[now], ansDist);
            for (Integer next : graph.get(now)) {
                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}