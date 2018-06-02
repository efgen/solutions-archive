import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main_Triang implements Runnable {
    double sq(double x) {
        return x * x;
    }

    double[] cross(double[] v1, double[] v2) {
        double[] r = new double[3];
        // xx yy zz
        // v1[0] v1[1] v1[2]
        // v2[0] v2[1] v2[2]
        r[0] = v1[1] * v2[2] - v2[1] * v1[2];
        r[1] = v1[0] * v2[2] - v2[0] * v1[2];
        r[2] = v1[0] * v2[1] - v2[0] * v1[1];
        r[1] *= -1;
        return r;
    }

    double[] diff(double x1, double y1, double z1, double x2, double y2, double z2) {
        double[] r = new double[3];
        r[0] = x2 - x1;
        r[1] = y2 - y1;
        r[2] = z2 - z1;
        return r;
    }

    double[] diff(double[] v1, double[] v2) {
        double[] r = new double[3];
        r[0] = v2[0] - v1[0];
        r[1] = v2[1] - v1[1];
        r[2] = v2[2] - v1[0];
        return r;
    }

    double dot(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }

    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        double X = nextDouble();
        double Y = nextDouble();
        double Z = nextDouble();
        double[] P = new double[3];
        P[0] = X;
        P[1] = Y;
        P[2] = Z;
        double[] x = new double[m];
        double[] y = new double[m];
        double[] z = new double[m];
        int[][] t = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                t[i][k] = nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            x[i] = nextDouble();
            y[i] = nextDouble();
            z[i] = nextDouble();
        }

        double closest = 1e+100;
        int res = -1;
        for (int i = 0; i < n; i++) {
            double x0 = x[t[i][0]];
            double y0 = x[t[i][1]];
            double z0 = x[t[i][2]];

            double ax = x[t[i][1]] - x0;
            double ay = y[t[i][1]] - y0;
            double az = z[t[i][1]] - z0;

            double bx = x[t[i][2]] - x0;
            double by = y[t[i][2]] - y0;
            double bz = z[t[i][2]] - z0;

            double nx = ay * bz - az * by;
            double ny = -(ax * bz - az * bx);
            double nz = ax * by - ay * bx;
            double d = Math.sqrt(sq(nx) + sq(ny) + sq(nz));
            nx /= d;
            ny /= d;
            nz /= d;

            double dist = Math.abs(nx * (X - x0) + ny * (Y - y0) + nz * (Z - z0));

            double[] ba = diff(x[t[i][1]], y[t[i][1]], z[t[i][1]], x[t[i][0]], y[t[i][0]], z[t[i][0]]);
            double[] cb = diff(x[t[i][2]], y[t[i][2]], z[t[i][2]], x[t[i][1]], y[t[i][1]], z[t[i][1]]);
            double[] ac = diff(x[t[i][0]], y[t[i][0]], z[t[i][0]], x[t[i][2]], y[t[i][2]], z[t[i][2]]);

            double[] pa = diff(X, Y, Z, x[t[i][0]], y[t[i][0]], z[t[i][0]]);
            double[] pb = diff(X, Y, Z, x[t[i][1]], y[t[i][1]], z[t[i][1]]);
            double[] pc = diff(X, Y, Z, x[t[i][2]], y[t[i][2]], z[t[i][2]]);

            double[] N = new double[3];
            N[0] = nx;
            N[1] = ny;
            N[2] = nz;

            if (dot(N, cross(ba, pa)) < 0 ||  dot(N, cross(cb, pb)) < 0 || dot(N, cross(ac, pc)) < 0) {
                continue;
            }

                if (dist < closest) {
                    closest = dist;
                    res = i;
                }
           // out.println(dist);
        }

        out.printf("%.6f\n%d", closest, res);
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();
            br.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(123);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) {
        new Thread(new Main_Triang()).start();
    }
}
