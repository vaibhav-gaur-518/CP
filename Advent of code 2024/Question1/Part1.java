/*
 * ShadowMaster
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class Part1 {
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

    static final int N = 1000;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        List<Integer> arrA = new ArrayList<>();
        List<Integer> arrB = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();

            arrA.add(a);
            arrB.add(b);
        }

        Collections.sort(arrA);
        Collections.sort(arrB);

        long sum = 0;
        for(int i = 0; i < N; i++) {
            sum += Math.abs(arrA.get(i) - arrB.get(i));
        }

        out.println(sum);

        out.close();
    }

    private static void test(FastReader fr) throws IOException {

    }

}

/*
 * 
 */