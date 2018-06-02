import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	int inf = 1000000000;
	class Dish {
		String name;
		int w,p;
		Dish() {
			name = in.next();
			p = in.nextInt();
			w = (int)Math.round((in.nextDouble()*1000));
		}
	}
	void solve() throws IOException	{
		int n = in.nextInt();
		int m = in.nextInt();
		Dish[] d = new Dish[n];	
		for (int i=0; i<n; i++) d[i] = new Dish();
		int maxp = (m+11)*1000+123;
		int[] a = new int[maxp];
		int[] dif = new int[maxp];
		Arrays.fill(a,inf); a[0] = 0;
		int[][] dp = new int[maxp][n];
		for (int x=1; x<maxp; x++) 
			for (int i=0; i<n; i++)
				if (d[i].w<=x) {
					int y = x-d[i].w;
					if ((a[x]>a[y]+d[i].p) ||
					  (a[x]==a[y]+d[i].p && dif[x]<dif[y]+(dp[y][i]==0?1:0) )) {
						for (int j=0; j<n; j++) dp[x][j] = dp[y][j];
						dif[x] = dif[y];
						if (dp[x][i]==0) dif[x]++;
						dp[x][i]++;
						a[x]=a[y]+d[i].p;
					  }
				}
		int res = m*1000;
		for (int i=res; i<maxp; i++)
			if (a[i]<a[res] || (a[i]==a[res] && dif[i]>dif[res])) res = i;
		
		out.println(a[res]);
		for (int i=0; i<n; i++)
			if (dp[res][i]>0) out.println(d[i].name+" "+dp[res][i]);
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