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

public class D {
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
        int T = fr.nextInt();
        while(T > 0){
            test(fr);
            T--;
        }
    }

    private static void test(FastReader fr) throws IOException {
        int N = fr.nextInt();
        int M = fr.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) A[i] = fr.nextInt();
        for (int i = 0; i < N; i++) B[i] = fr.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int target = M - B[i];
            Integer a = map.ceilingKey(target); 
            if (a == null) {
                a = map.firstKey();
            }

            sum += (a + B[i]) % M;

            if (map.get(a) == 1) map.remove(a);
            else map.put(a, map.get(a) - 1);
        }

        logn(sum);
    }

}

/*
 * 
 */