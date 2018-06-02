import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main_Cyl implements Runnable {
    double sq(double x) {
        return x * x;
    }

    void solve() throws IOException {
        double d;
        double e1x = nextDouble();
        double e1y = nextDouble();
        double e2x = nextDouble();
        double e2y = nextDouble();
        double e3x = nextDouble();
        double e3y = nextDouble();
        double e4x = nextDouble();
        double e4y = nextDouble();

        double ox = nextDouble();
        double oy = nextDouble();
        double oz = nextDouble();

        double axx = nextDouble();
        double axy = nextDouble();
        double axz = nextDouble();

        double ayx = nextDouble();
        double ayy = nextDouble();
        double ayz = nextDouble();

        double a = Math.sqrt(sq(e1x - e3x) + sq(e1y - e3y));
        double b = Math.sqrt(sq(e2x - e4x) + sq(e2y - e4y));

        double cx = (e1x + e3x) / 2;
        double cy = (e1y + e3y) / 2;

        if (a < b) {
            double t;
            t = e1x;
            e1x = e2x;
            e2x = t;
            t = e1y;
            e1y = e2y;
            e2y = t;

            t = e3x;
            e3x = e4x;
            e4x = t;
            t = e3y;
            e3y = e4y;
            e4y = t;

            t = a;
            a = b;
            b = t;
        }

        double e = Math.sqrt(1 - sq(b / a));

        double alf = Math.acos(e);
        double r = a * Math.sin(alf) / 2;

        double gcx = ox + axx * cx + ayx * cy;
        double gcy = oy + axy * cx + ayy * cy;
        double gcz = oz + axz * cx + ayz * cy;

        double ge1x = ox + axx * e1x + ayx * e1y;
        double ge1y = oy + axy * e1x + ayy * e1y;
        double ge1z = oz + axz * e1x + ayz * e1y;

        double ax = ge1x - gcx;
        double ay = ge1y - gcy;
        double az = ge1z - gcz;
        d = Math.sqrt(sq(ax) + sq(ay) + sq(az));

        if (ax*axx + ay*axy + az*axz < 0) {
            d = - d;
        }




        ax /= d;
        ay /= d;
        az /= d;

        double nx = axy * ayz - axz * ayy;
        double ny = -(axx * ayz - axz * ayx);
        double nz = axx * ayy - axy * ayx;
        d = Math.sqrt(sq(nx) + sq(ny) + sq(nz));
        nx /= d;
        ny /= d;
        nz /= d;

        double x = Math.cos(alf);
        double y = Math.sin(alf);

        double gax = ax * x + nx * y;
        double gay = ay * x + ny * y;
        double gaz = az * x + nz * y;

        out.printf("%.6f %.6f %.6f\n", gcx, gcy, gcz);
        out.println(r);
        out.printf("%.6f %.6f %.6f\n", gax, gay, gaz);

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
        new Thread(new Main_Cyl()).start();
    }
}
