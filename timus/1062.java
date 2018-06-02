import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	class Simplex {
		double[][] a;
		double[] cost;
		int[] vartype;		
		int[] baseid;
		int n, m;
		double SOLUTION = 0;
		
		public Simplex(double[][] A, double[] b, double[] c) { // AX<=b cX -> max Ð²ÑÐµ b>=0
			n =  A.length;
			m = A[0].length;
			vartype = new int[n+m];
			baseid = new int[n];
			a = new double[n+1][n+m+1];
			for (int i=0; i<n; i++)
				for (int j=0; j<m; j++)
					a[i][j] = A[i][j];
			for (int i=0; i<n; i++) a[i][n+m] = b[i];
			for (int i=0; i<n; i++) a[i][i+m] = 1;
			for (int i=0; i<m; i++) a[n][i] = c[i];
			Arrays.fill(vartype, -1);
			for (int i=0; i<n; i++) vartype[m+i] = i;
			for (int i=0; i<n; i++) baseid[i] = m+i;
			m += n;			
		}
		
		private void exchange(int v, int u) { // v - ÑÑÐ°Ð²Ð½ÐµÐ½Ð¸Ðµ u - Ð½Ð¾Ð²Ð°Ñ Ð±Ð°Ð·Ð¸ÑÐ½Ð°Ñ
			double t = a[v][u];
			for (int j=0; j<=m; j++) a[v][j] /= t;
			for (int i=0; i<=n; i++)
				if (i!=v) {
					t = a[i][u];
					for (int j=0; j<=m; j++) 
						a[i][j] -= a[v][j]*t;
				}
			vartype[baseid[v]] = -1;
			baseid[v] = u;
			vartype[baseid[v]] = v;
		}
		
		void solve() {
			while (true) {
				int u = -1;
				for (int i=0; i<m; i++)
					if (vartype[i]<0 && a[n][i]>eps){
						u = i;
						break;
					}
				if (u<0) break;
				int v = -1;
				double minr = Double.POSITIVE_INFINITY;
				for (int i=0; i<n; i++)
					if (a[i][u]>0) {
						double t = a[i][m]/a[i][u];
						if (t<minr) {
							minr = t;
							v = i;
						}
					}
				if (v<0) {
					//Ð·Ð°Ð´Ð°ÑÐ° Ð½Ðµ Ð¾Ð³ÑÐ°Ð½Ð¸ÑÐµÐ½Ð°
					SOLUTION = Double.POSITIVE_INFINITY;
					return;
				}
				exchange(v, u);							
			}
		}
		
	}
	void solve() throws IOException {
		int n = nextInt();
		if (n==1) {
			out.println("Yes");
			return;
		}
		double[][] v = new double[n][3];
		for (int i=0; i<n; i++)
			for(int j=0; j<3; j++)
				v[i][j] = 1./nextDouble();
		double[][] a = new double[n-1][4];
		double[] c = new double[4]; c[3] = 1;
		double[] b = new double[n-1];
		for (int i=0; i<n; i++) {
			boolean ok = true;
			int k = 0;
			for (int j=0; j<n; j++)
				if (j!=i) {
					double sum = 0;
					boolean eq = true;
					for (int t=0; t<3; t++) {
						a[k][t] = v[i][t]-v[j][t];
						eq &= Math.abs(a[k][t])<eps;
						sum += a[k][t]; 
					}
					a[k][3] = sum;
					ok &= !eq;
					k++;
				}
			Simplex s = new Simplex(a, b, c);
			s.solve();
			if (s.SOLUTION==Double.POSITIVE_INFINITY && ok) out.println("Yes"); else out.println("No");
		}	
		
		
    }    

		
    static final int inf = 1000000000+10;
    static final double eps = 1e-8;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
            //br = new BufferedReader(new FileReader(FileName+".in"));
            //out = new PrintWriter(FileName+".out");
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //br = new BufferedReader(new FileReader("input.txt"));
            //out = new PrintWriter("output.txt");
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
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
    	new Solution().run();    
    }    
}