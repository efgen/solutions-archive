import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	//static final String FileName = "test";
	void solve() throws IOException{
		int n = nextInt();
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				a[i][j] = nextInt();
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				b[i][j] = (i!=j?1000000000:0);
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (a[i][j]+a[j][i]<2) {
					b[i][j] = a[i][j];
					b[j][i] = a[j][i];
				}
	/*	for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++)
				out.print(b[i][j]+" ");
			out.println();
		}
		out.println(); */
		for (int k=0; k<n; k++)
			for (int i=0; i<n; i++)
				for (int j=0; j<n; j++)
					if (b[i][j]>b[i][k]+b[k][j]) 
						b[i][j]=b[i][k]+b[k][j];
		/*for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++)
				out.print(b[i][j]+" ");
			out.println();
		} */
		boolean ok = true;
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				ok &= b[i][j] == a[i][j];
		if (ok) {
			out.println("YES"); 
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++)
					if (a[i][j]+a[j][i]<2) {
						if (a[i][j]==1) out.print(2); else
						if (a[j][i]==1) out.print(1); else
						if (i==j) out.print(0); else out.print(1);
					} else out.print(0);
				out.println();
			}
		} else out.println("NO");
					
	}
	
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
		new Main().run();
	}
}
