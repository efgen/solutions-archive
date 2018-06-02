import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	int[] c;
	boolean[][] a;
	boolean ok = true;
	int n,sz1,sz2;
	void dfs(int v,int f) {
		c[v] = f;
		if (f>0) sz1++; else sz2++;
		for (int i=1; i<=n; i++)
			if (a[v][i])
				if (c[i]==0) dfs(i,-f); else 
					if (c[i]==f) {
						out.println("IMPOSSIBLE");
						out.close();
						System.exit(0);
					}
	}
	void solve() throws IOException	{
		n = 2*in.nextInt();
		int m = in.nextInt();
		a = new boolean[n+1][n+1];
		int[][][] dp = new int[n+1][n+1][n+1];		
		while (m-->0) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x][y] = a[y][x] = true;
		}
		int k = 0;
		int[] S1 = new int[n+1];
		int[] S2 = new int[n+1];
		c = new int[n+1];
		dp[0][0][0] = 1;
		for (int i=1; i<=n; i++)
			if (c[i]==0) {
				sz1 = 0;
				sz2 = 0;
				dfs(i,k+1);				
				for (int x=n; x>=0; --x)
					for (int y=n; y>=0; --y)
						if (dp[k][x][y]!=0) {
					//		out.print('.');
							if (x+sz1<=n && y+sz2<=n) dp[k+1][x+sz1][y+sz2] = 1;
							if (x+sz2<=n && y+sz1<=n) dp[k+1][x+sz2][y+sz1] = -1;
						}
				k++;
				S1[k] = sz1;
				S2[k] = sz2;
			}	
		n/=2;
		if (dp[k][n][n]==0) {
				out.println("IMPOSSIBLE");
				out.close();
				System.exit(0);
		}
		int x = n, y = n;
		Vector<Integer> r1 = new Vector<Integer>();
		Vector<Integer> r2 = new Vector<Integer>();

		while (k>0) {
			if (dp[k][x][y]>0) {
				x -= S1[k]; y -= S2[k];
				for (int i=1; i<=2*n; i++) {
					if (c[i]==k) r1.add(i);
					if (c[i]==-k) r2.add(i);  
				}
			} else {
				x -= S2[k]; y -= S1[k];
				for (int i=1; i<=2*n; i++) {
					if (c[i]==-k) r1.add(i);
					if (c[i]==k) r2.add(i);  
				}
			}
			k--;
		}
		for (int q:r1) out.print(q+" ");
		out.println();
		for (int q:r2) out.print(q+" ");
	}


	//StreamTokenizer in;
	Scanner in;
	PrintWriter out;

	/*int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}*/
	public void run(){
		
		try {
			//in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			in = new Scanner(System.in);
			in.useLocale(Locale.US);
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		} catch (IOException e){throw new IllegalStateException(e);}
	}
	public static void main(String[] args)	{
		new Thread(new Main()).start();
	}
}