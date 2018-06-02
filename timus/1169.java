import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	
	void solve() throws IOException	{
		int n = in.nextInt();
		int[] f = new int[n+1];
		for (int i=1; i<=n; i++) f[i] = i*(i-1)/2;
		int m = f[n];
		int K = m-in.nextInt();
		int[][] a = new int[n+1][m+1];	
		for (int i=1; i<=n; i++)
			for (int j=1; j<=f[i]; j++) a[i][j] = -1;
		
		for (int i=3; i<=n; i++) {
			a[i][f[i]] = 1;
			for (int j=2; j<i-1; j++) {
				for (int t=0; t<=f[j-1]; t++)
					if (a[j-1][t]>=0) a[i][t+f[i-j+1]] = j;
			}
		}
		/*for (int i=1; i<=n; i++) {
			out.print(f[i]+":");
			for (int j=0; j<=f[i];  j++)
				if (a[i][j]>=0) out.print(1); else  out.print(0);
			out.println();
		}*/
		if (a[n][K]<0) {
			out.println(-1);
			return;
		}
		for (int i=1; i<n; i++) out.println(i+" "+(i+1));
		while (n>0 && a[n][K]>0) {
			out.println(a[n][K]+" "+n);
			int x = f[n-a[n][K]+1];
			n = a[n][K]-1;
			K -= x;
		}	
	
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