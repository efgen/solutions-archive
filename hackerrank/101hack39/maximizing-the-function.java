import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task3 solver = new Task3();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task3 {
        int[] cnt;

        long getOnes(int l, int r) {
            if (l > r) {
                return 0;
            }
            return cnt[r] - (l == 0 ? 0 : cnt[l - 1]);
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int q = in.readInt();
            boolean[] a = new boolean[n + 1];
            boolean[] s = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                a[i + 1] = in.readInt() == 1;
            }
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] ^ a[i];
            }
            cnt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                cnt[i] = cnt[i - 1];
                if (s[i]) {
                    cnt[i]++;
                }
            }
            while (q-- > 0) {
                int l = in.readInt();
                int r = in.readInt() + 1;
                int k = in.readInt();
                if (k > 1) {
                    System.exit(123);
                }

                long L = r - l + 1;
                long e = getOnes(l, r);
                long res = e * (L - e);
                if (k == 1) {
                    for (int p = l; p <= r; p++) {
                        long t = getOnes(l, p);
                        long t2 = (r - p) - getOnes(p + 1, r);
                        e = t + t2;
                        res = Math.max(res, e * (L - e));
                    }
                    out.printLine(res);
                } else {
                    out.printLine(res);
                }

            }
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(long i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

