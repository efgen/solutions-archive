import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
	int inf = 100000000;
	String[] Names;
	int NSz = 0;
	
	int code(String s) {
		for (int i=0; i<NSz; i++) 
			if (Names[i].equals(s)) return i;
		Names[NSz] = s;
		return NSz++;
	}

	void solve() throws IOException	{
		int n = in.nextInt();
		int m = in.nextInt();
	
		boolean[][] A = new boolean[n][n];
		Names = new String[n];
		while (m-->0) {
			int x = code(in.next());
			int y = code(in.next());
			A[x][y] = A[y][x] = true;
		}
		int S = 1<<code(in.next());
		int sz = 1<<n;
		int[][] a = new int[sz][sz];		
		for (int i=0; i<sz; i++) a[i][0] = inf;
		for (int v=0; v<sz; v++)
			if ((v&S)>0)
			for (int u=0; u<sz; u++) {
				if ((v&u)>0) continue;
				boolean f = false;				
				for (int i=0; i<n && !f; i++)
					if ((v&(1<<i))>0)
					for (int j=0; j<n && !f; j++)
						if ((u&(1<<j))>0 && A[i][j]) {
							if (a[v^(1<<i)][u^(1<<j)]>0) {
								a[v][u] = i*n+j;
								f = true;
								break;
							}
						}	
			}
			
	
		int[] d = new int[sz];
		int[] p = new int[sz];
		Arrays.fill(d,inf); d[S] = 0;	
		Arrays.fill(p,-1);
		for (int v=1; v<sz; v++)
			if (d[v]<inf)
			for (int u=1; u<sz; u++) 
				
					if (((u&v)==0) && a[v][u]>0 && d[v|u]>d[v]+1) {
						d[u|v] = d[v]+1;
						p[u|v] = v;
					}
					
		
		Stack<String> res = new Stack<String>();
		out.println(d[sz-1]);	
		int v = sz-1;		
		while (p[v]>0) {
			int u = v;
			v = p[v];
			u ^= v;
			int vv = v, uu = u;
			int k = 0;
			while (a[vv][uu]>0 && uu>0) {
				int i = a[vv][uu]/n;
				int j = a[vv][uu]%n;
				res.push(Names[i]+" "+Names[j]);
				vv ^= (1<<i);
				uu ^= (1<<j);
				k++;					
			}
			res.push(""+k);
		}
		while (!res.isEmpty()) 
			out.println(res.pop());

	}
	

	//StreamTokenizer in;
	Scanner in;
	PrintWriter out;

/*	int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}*/
	public void run(){
		try
		{
			//in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
			in = new Scanner(System.in);
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