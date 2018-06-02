import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval);
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}
boolean[][] a;
int n;
int[] d;
boolean[] be;
void dfs(int v,int k,int p) {		
	out.print(v+1);
	out.print(" ");
	k--;
	if (k==0) { be[v] = true; return; }
	for (int i=0; i<n; i++)
		if (!a[v][i] && i!=p && d[i]!=n) {		
			if (k==1 && be[i]) continue;
			a[v][i] = a[i][v] = true;
			d[v]++; d[i]++;
			dfs(i,k,v);
			return;
		}
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br); 
  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  n = nextInt()*2;
  a = new boolean[n][n];
  d = new int[n];
  be = new boolean[n];
  for (int i=0; i<n; i++) a[i][i] = true;
  for (int i=0; i<n/2; i++) {
	  for (int b=0; b<n; b++)
		  if (!be[b]) {
			  be[b] = true;
			  dfs(b,n,-1);
			  break;
		  }
	  
	  out.println();
  }
  out.close();    
}   

}
