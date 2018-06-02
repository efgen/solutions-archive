import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	double eps = 1e-10;
	void solve() throws IOException	{
		int n = nextInt();
		int m = nextInt();
		double[][] R = new double[n+1][n+1];
		int[][] num = new int[n+1][n+1];
		while (m-->0) {
			int x = nextInt();
			int y = nextInt();
			int r = nextInt();
			if (R[x][y]<eps) R[x][y] = r; else R[x][y] = R[x][y]*r/(R[x][y]+r);			
		}
		double[][] a = new double[n*(n+3)][n*(n+3)];
		m = 0;
		int k = 0;
		for (int i=1; i<=n; i++)
			for (int j=i+1; j<=n; j++)
				if (R[i][j]>=eps) {
					num[i][j] = ++m;
					k++;
					a[k][i] = 1; 
					a[k][j] = -1;
					a[k][n+m] = -R[i][j];
					
				}
		for (int i=1; i<=n; i++)
			for (int j=i+1; j<=n; j++)
				if (num[i][j]>0) num[j][i] = num[i][j];
		
		for (int i=2; i<n; i++) {
			k++;
			for (int j=1; j<=n; j++)
				if (num[i][j]>0)
					if (j<i) a[k][n+num[i][j]] = 1; else a[k][n+num[i][j]] = -1;
		}
		
		a[++k][n] = 1;
		a[++k][1] = 1; a[k][n+m+1] = 1;
		
		int N = n;
		n = k;

		for (k=1; k<=n; k++) {
			int b = k;
			for (int i=k; i<=n; i++) 
				if (Math.abs(a[i][k])>Math.abs(a[b][k])) b = i;
			for (int i=k; i<=n+1; i++) {
				double q = a[k][i]; a[k][i] = a[b][i]; a[b][i] = q;
			}
			for (int i=n+1; i>=k; --i) a[k][i] /= a[k][k];
			for (int i=k+1; i<=n; i++) {
				double q = -a[i][k];
				for (int j=k; j<=n+1; j++) a[i][j] += q*a[k][j];
			}					
			
		}
			
		
		double[] x = new double[n+1];
		for (k=n; k>0; --k) {
			x[k] = a[k][n+1];
			for (int i=1; i<k; i++) a[i][n+1] -= a[i][k]*x[k];
		}
		double res = 0;
		for (int i=1; i<=N; i++)
			if (num[1][i]>0) res += x[num[1][i]+N];		
		out.printf(Locale.US,"%1.2f",1/res);
		

	
	}

	StreamTokenizer in;
	PrintWriter out;
	int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	public void run(){
		try
		{
			in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}

