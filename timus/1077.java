import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;


public static void main(String[] args) throws IOException {
new Main().run();
}
int n = 0,time = 0,lev = 0;
boolean[][] a;
int[] d, st;

void dfs(int v) {
	d[v] = 1;
	for (int i=1; i<=n; i++)
		if (a[v][i] && d[i]==0) dfs(i);
}
void show(int v) {
	int i = 1;
	while (st[i]!=v) i++;
	out.print(lev-i+1);
	for (;i<=lev; i++) out.print(" "+st[i]);
	out.println();
}
void cycle(int v) {
	d[v] = ++time;
	st[++lev] = v;
	for (int i=1; i<=n; i++)
		if (a[v][i])
			if (d[i]==0) cycle(i); else
				if (d[i]<d[v] && i!=st[lev-1]) show(i);
	lev--;
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out); 
  n = in.nextInt();
  a = new boolean[n+1][n+1];
  int m = in.nextInt(); 
  while (m-->0) {
	  int x = in.nextInt();
	  int y = in.nextInt();
	  a[x][y] = true;
	  a[y][x] = true;
  }
  int res = -n;
  for (int i=1; i<=n; i++)
	  for (int j=i+1; j<=n; j++)
		  if (a[i][j]) res++;
  d = new int[n+1];
  for (int i=1; i<=n; i++)
	  if (d[i]==0) {
		  res++;
		  dfs(i);
	  }
  out.println(res);
  d = new int[n+1];
  st = new int[n+1];
  for (int i=1; i<=n; i++)
	  if (d[i]==0) cycle(i);
  in.close(); out.close();
}

}
