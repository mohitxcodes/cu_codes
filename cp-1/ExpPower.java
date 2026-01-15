import java.io.*;
import java.util.*;

public class ExpPower {
    static final long MOD = 1000000007;

    static long power(long a, long b) {
        if (b == 0)
            return 1;
        a %= MOD;
        long res = power(a, b / 2);
        res = (res * res) % MOD;
        if (b % 2 == 1)
            res = (res * a) % MOD;
        return res;
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        try {
            if (sc.hasNext()) {
                long n = sc.nextLong();
                while (n-- > 0) {
                    long a = sc.nextLong();
                    long b = sc.nextLong();
                    out.println(power(a, b));
                }
            }
        } catch (Exception e) {
            // End of input
        }

        out.flush();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            String s = next();
            if (s == null)
                throw new RuntimeException("End of Input");
            return Long.parseLong(s);
        }

        boolean hasNext() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return false;
                    if (line.trim().isEmpty())
                        continue;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }
    }
}