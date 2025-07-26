/*
 * ShadowMaster
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class E {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        char nextChar() throws IOException {
            return next().charAt(0);
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    static void logn(Object o) {
        System.out.println(o);
    }

    static void log(Object o) {
        System.out.print(o + " ");
    }

    static final long INF = (long) 1e18;
    static int N;
    static long[][] dist;
    static boolean[] hasAirport;
    static long T;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        solve(fr);
    }

    private static void solve(FastReader fr) throws IOException {
        N = fr.nextInt();
        int M = fr.nextInt();
        dist = new long[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < N; i++) dist[i][i] = 0;

        for (int i = 0; i < M; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            int c = fr.nextInt();
            dist[u][v] = Math.min(dist[u][v], c);
            dist[v][u] = Math.min(dist[v][u], c);
        }

        int K = fr.nextInt();
        T = fr.nextLong();
        hasAirport = new boolean[N];
        for (int i = 0; i < K; i++) {
            int city = fr.nextInt() - 1;
            hasAirport[city] = true;
        }

        int Q = fr.nextInt();
        for (int q = 0; q < Q; q++) {
            String[] parts = fr.nextLine().split(" ");
            while (parts.length < 1 || parts[0].isEmpty()) parts = fr.nextLine().split(" ");

            if (parts[0].equals("1")) {
                int x = Integer.parseInt(parts[1]) - 1;
                int y = Integer.parseInt(parts[2]) - 1;
                int t = Integer.parseInt(parts[3]);
                if (dist[x][y] > t) {
                    dist[x][y] = t;
                    dist[y][x] = t;
                }
            } else if (parts[0].equals("2")) {
                int x = Integer.parseInt(parts[1]) - 1;
                hasAirport[x] = true;
            } else if (parts[0].equals("3")) {
                long[][] curDist = new long[N][N];
                for (int i = 0; i < N; i++)
                    curDist[i] = Arrays.copyOf(dist[i], N);

                for (int i = 0; i < N; i++) {
                    if (!hasAirport[i]) continue;
                    for (int j = 0; j < N; j++) {
                        if (i != j && hasAirport[j])
                            curDist[i][j] = Math.min(curDist[i][j], T);
                    }
                }

                for (int k = 0; k < N; k++) {
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (curDist[i][k] < INF && curDist[k][j] < INF)
                                curDist[i][j] = Math.min(curDist[i][j], curDist[i][k] + curDist[k][j]);
                        }
                    }
                }

                long total = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (curDist[i][j] < INF) {
                            total += curDist[i][j];
                        }
                    }
                }
                logn(total);
            }
        }
    }

    private static void test(FastReader fr) throws IOException {

    }

}

/*
 * 
 */
