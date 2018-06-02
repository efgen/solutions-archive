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
import java.util.*;

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
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }


    static class Task {
        int n;
        int[] c;
        boolean[] f;

        Vector<Integer>[] a;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();



        int dfs(int v) {
            f[v] = true;
            if (!map.containsKey(c[v])) {
                map.put(c[v], 1);
            } else {
                map.put(c[v], map.get(c[v])+1);
            }
            int res = map.size();

            for (int x:a[v]) {
                if (!f[x]) {
                    res += dfs(x);
                }
            }
            if (map.get(c[v]) == 1) {
                map.remove(c[v]);
            } else {
                map.put(c[v], map.get(c[v])-1);
            }
            return res;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.readInt();
            c = new int[n+1];
            a = new Vector[n+1];
            f = new boolean[n+1];
            for (int i=1; i<=n; i++) {
                a[i] = new Vector<Integer>();
            }
            for (int i=1; i<=n; i++) {
                c[i] = in.readInt();
            }
            for (int i=1; i<n; i++) {
                int x = in.readInt();
                int y = in.readInt();
                a[x].add(y);
                a[y].add(x);
            }
            for (int i=1; i<=n; i++) {
                Arrays.fill(f, false);
                map.clear();
                out.println(dfs(i));
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

        public void println(int i) {
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
