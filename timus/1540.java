import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

int[][] a;
int[][][] f;
int n;
int hod(int p, int i,int j, int x) {
	int res = 0;
	int pos = i;
	for (int t=i; t<=j; t++) 
		if (a[p][t]<=x) {
			if (pos<=t-1) res ^= val(p,pos,t-1);
			pos = t+1;
		}
	if (pos<=j) res ^= val(p,pos,j);
	return res;
}
int val(int p, int i, int j) {
	if (f[p][i][j]>=0) return f[p][i][j];	
	TreeSet<Integer> t = new TreeSet<Integer>();
	for (int x=i; x<=j; x++) t.add(hod(p,i,j,a[p][x]));
	int res = 0;
	while (t.contains(res)) res++;
	return f[p][i][j]=res;
}
public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  int n = in.nextInt();
  a = new int[n][];
  for (int i=0; i<n; i++) {
	  int k = in.nextInt();
	  a[i] = new int[k];
	  for (int j=0; j<k; j++) a[i][j] = in.nextInt();
  }
  f = new int[n][100][100];
  for (int i=0; i<n; i++)
	  for (int j=0; j<a[i].length; j++) {
		  f[i][j][j] = 1;
		  for (int k=j+1; k<a[i].length; k++)
			  f[i][j][k] = -1;
	  }

  for (int i=0; i<n; i++) 
	  f[i][0][a[i].length-1] = val(i,0,a[i].length-1);
  int res = 0;
  for (int i=0; i<n; i++)
	  res ^= f[i][0][a[i].length-1];
  
//  out.println(res);
  if (res==0) out.println("S"); else {
	  out.println("G");
	  for (int i=0; i<n; i++) {
		  int x = res^f[i][0][a[i].length-1];
		  for (int j=0; j<a[i].length; j++) {
			  if ((x^hod(i,0,a[i].length-1,a[i][j]))==0) {
				  out.println((i+1)+" "+(j+1));
				  in.close(); out.close();
				  return;
			  }
		  }
	  }
  }
  in.close(); out.close();
}
}


