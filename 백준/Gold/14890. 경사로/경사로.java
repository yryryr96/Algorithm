import java.io.*;
import java.util.*;

public class Main {

    static int N,L;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println("searchingRow() = " + searchingRow());
//        System.out.println("searchingCol() = " + searchingCol());
        System.out.println(searchingCol()+searchingRow());
    }

    // 위아래
    static int searchingRow() {

        int cnt = 0;
        for (int j = 0; j < N; j++) {
//            System.out.println("j = " + j);
            boolean[] visited = new boolean[N];
            int r1 = 0;
            int r2 = 0;
            int cntLow = 0;
            int cntHigh = 0;
            boolean temp = true;

            // 아래로 가면서 더 작아지는
            while (r1 < N-1) {
                int k = 1;

                if (Math.abs(map[r1+1][j] - map[r1][j]) > 1) {
                    temp = false;
                    break;
                }

                if (map[r1+1][j] == map[r1][j]) {
                    r1++;
                    continue;
                }
                
                if (map[r1][j] - map[r1+1][j] == 1) {
                    while (r1+k < N) {

                        if (map[r1+k][j] == map[r1][j] - 1 && !visited[r1+k]) cntLow++;
                        else {
                            temp = false;
                            break;
                        }

                        if (cntLow == L) {
                            for (int i = 1; i <= k; i++) {
                                visited[r1+i] = true;
                            }
                            break;
                        }
                        k++;
                    }

                    if (cntLow != L) temp = false;
                    else {
                        cntLow = 0;
                    }
                    if (!temp) break;
                    r1 = r1 + k;
                } else {
                    r1++;
                }

            }
            // 아래로 가면 더 커지는
            while (r2 < N-1) {

                int k = 1;

                if (Math.abs(map[r2+1][j] - map[r2][j]) > 1) {
                    temp = false;
                    break;
                }

                if (map[r2+1][j] == map[r2][j]) {
                    r2++;
                    continue;
                }

                if (map[r2+1][j] - map[r2][j] == 1) {
                    int r = r2 + 1;
                    while (r-k >= 0) {

                        if (map[r-k][j] + 1 == map[r][j] && !visited[r-k]) cntHigh++;
                        else {
                            temp = false;
                            break;
                        }

                        if (cntHigh == L) {
                            for (int i = 1; i <= k; i++) {
                                visited[r-i] = true;
                            }
                            break;
                        }
                        k++;
                    }

                    if (cntHigh != L) temp = false;
                    else {
                        cntHigh = 0;
                    }

                    if (!temp) break;
                    r2 = r;
                } else {
                    r2++;
                }
            }

            if (temp) cnt++;

        }

        return cnt;
    }

    static int searchingCol() {

        int cnt = 0;
        for (int i = 0; i < N; i++) {
//            System.out.println("i = " + i);
            boolean[] visited = new boolean[N];
            int c1 = 0;
            int c2 = 0;
            int cntLow = 0;
            int cntHigh = 0;
            boolean temp = true;

            // 오른쪽으로 가면서 더 작아지는
            while (c1 < N-1) {
                int k = 1;

                if (Math.abs(map[i][c1+1] - map[i][c1]) > 1) {
                    temp = false;
                    break;
                }

                if (map[i][c1+1] == map[i][c1]) {
                    c1++;
                    continue;
                }

                if (map[i][c1] - map[i][c1+1] == 1) {
                    while (c1+k < N) {
                        if (map[i][c1] - 1 == map[i][c1+k] && !visited[c1+k]) cntLow++;
                        else {
                            temp = false;
                            break;
                        }
                        
                        if (cntLow == L) {
                            for (int j = 1; j <= k; j++) {
                                visited[c1+j] = true;
                            }
                            break;
                        }
                        k++;
                    }

                    if (cntLow != L) temp = false;
                    else {
                        cntLow = 0;
                    }
                    if (!temp) break;
                    c1 = c1 + k;
                } else {
                    c1++;
                }

            }
            // 오른쪽으로 가면 더 커지는
            while (c2 < N-1) {
                int k = 1;

                if (Math.abs(map[i][c2+1] - map[i][c2]) > 1) {
                    temp = false;
                    break;
                }

                if (map[i][c2+1] == map[i][c2]) {
                    c2++;
                    continue;
                }

                if (map[i][c2+k] - map[i][c2] == 1) {
                    int c = c2 + 1;
                    while (c-k >= 0) {

                        if (map[i][c-k] + 1 == map[i][c] && !visited[c-k]) cntHigh++;
                        else {
                            temp = false;
                            break;
                        }

                        if (cntHigh == L) {
                            for (int j = 1; j <= k; j++) {
                                visited[c-j] = true;
                            }
                            break;
                        }
                        k++;
                    }

                    if (cntHigh != L) temp = false;
                    else {
                        cntHigh = 0;
                    }
                    if (!temp) break;
                    c2 = c;
                } else {
                    c2++;
                }
            }
            if (temp) cnt++;
//            System.out.println("Arrays.toString(visited) = " + Arrays.toString(visited));
//            System.out.println("i = " + i + " temp = " + temp);
        }

        return cnt;
    }
}