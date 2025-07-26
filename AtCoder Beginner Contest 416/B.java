/*
 * ShadowMaster
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class B {
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
        String S = fr.next();
        int n = S.length();
        StringBuilder T = new StringBuilder();
        boolean O = true;

        for(int i = 0; i < n; i++) {
            char ch = S.charAt(i);
            if(ch == '#'){
                T.append(ch);
                O = true;  
            } else {
                if (O) {
                    T.append('o');
                    O = false;
                } else {
                    T.append('.');
                }
            }
        }
        logn(T.toString());
    }

    private static void test(FastReader fr) throws IOException {

    }
}

/*
 * 
 */
