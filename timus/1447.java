import java.io.*;
import java.util.*;

public class Main implements Runnable {
	BufferedReader br;
	StreamTokenizer ST;
	PrintWriter out;
	Scanner in;
	double inf = 1e+100;
	int nextInt() throws IOException {
		ST.nextToken();
		return(int) ST.nval;
	}
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			ST = new StreamTokenizer(br);
			out = new PrintWriter(System.out);
			in = new Scanner(br);
			solve();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void solve()throws IOException{
		int n = nextInt();
		int m = nextInt();
		int[][] a1 = new int[n+1][n+1];
		int[][] a2 = new int[n+1][n+1];
		while (m-->0) {
			int x = nextInt();
			int y = nextInt();
			a2[x][y] = a2[y][x]  = nextInt();
			a1[x][y] = a1[y][x]  = nextInt();
		}
		double L = 0, R = 1e+9;
		double[][] a = new double[n+1][n+1];
		boolean[] f = new boolean[n+1];
		double[] d = new double[n+1];
		for (double[] aa:a) Arrays.fill(aa, inf);
		double eps = 1e-8/2;
		while (R-L>eps) {
			double mid = (L+R)/2;
			for (int i=1; i<=n; i++)
				for (int j=1; j<=n; j++)
					if (a1[i][j]>0) 
						a[i][j] = a1[i][j]-a2[i][j]*mid; 
			int p = 1;
			Arrays.fill(f, false);
			Arrays.fill(d, inf);
			d[1] = 0;
			while (p>0) {
				f[p] = true;
				for (int i=1; i<=n; i++)
					if (!f[i] && a[p][i]<d[i]) d[i] = a[p][i];
				p = 0;
				for (int i=1; i<=n; i++)
					if (!f[i] && d[i]<d[p]) p = i;
			}
			double w = 0;
			for (int i=1; i<=n; i++) w += d[i];
			if (w<0) R = mid; else L = mid;			
		}
		out.println(R);		
	}

}
