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

public class C {
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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int K = fr.nextInt();
        int X = fr.nextInt();
        String[] S = new String[N];
        List<String> result = new ArrayList<>();

         for (int i = 0; i < N; i++) {
            S[i] = fr.next();
        }

        generateString(new ArrayList<>(), 0, N, K, S, result);

        Collections.sort(result);
        logn(result.get(X - 1));
    }

    private static void generateString(List<Integer> current, int depth, int N, int K, String[] S, List<String> result) {
        if (depth == K) {
            StringBuilder sb = new StringBuilder();
            for (int idx : current) {
                sb.append(S[idx]);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            current.add(i);
            generateString(current, depth + 1, N, K, S, result);
            current.remove(current.size() - 1);
        }
    }

    private static void test(FastReader fr) throws IOException {
        
    }

}

/*
 * 
 */