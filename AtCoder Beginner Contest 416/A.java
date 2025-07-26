/*
 * ShadowMaster
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while(st == null || !st.hasMoreTokens()){
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
        int L = fr.nextInt();
        int R = fr.nextInt();
        String S = fr.next();

        for (int i = L - 1; i <= R - 1; i++) {
            if(S.charAt(i) != 'o') {
                logn("No");
                return ;
            }
        }

        logn("Yes");
    }

    private static void test(FastReader fr) throws IOException {

    }
}

/*
 * 
 */
