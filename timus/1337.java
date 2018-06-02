import java.io.*;   
import java.util.*;   
import java.math.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   
int inf = 1000000000;   

public static void main(String[] args) throws IOException {   
    new Main().run();   
}   
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = nextInt();
  int L = nextInt();
  int[] pd = new int[L+1];
  int[] nd = new int[L+1];
  boolean[][] a = new boolean[L+1][n+1];
  for (int i=1; i<=n; i++) pd[i] = nextInt();
  for (int i=1; i<=n; i++) nd[pd[i]] = i; 
  for (int i=1; i<=n; i++) {
	  while (true) {
		  int x = nextInt();
		  if (x==0) break;
		  a[pd[i]][x] = true;
	  }
  }
  boolean[] have = new boolean[n+1];
  boolean[] need = new boolean[n+1];
  int d = nextInt();
  while (true) {
	  int x = nextInt();
	  if (x==0)break;
	  have[x] = true;
  }
  while (true) {
	  int x = nextInt();
	  if (x==0)break;
	  need[x] = true;
  }
  int dd = 0;
  boolean all = true;
  int res = 0;
  Vector<Integer> R = new Vector<Integer>();
  while (dd<=L) {	  
	  if (nd[d]>0 && !have[nd[d]]) {		  
		  boolean can = true;
	  	  for (int i=1; i<=n; i++)
	  		  if (a[d][i] && !have[i]) { can = false; break; }
	  	  if (can) {
	  		  dd = 0;
	  		  have[nd[d]] = true;
	  		  R.add(nd[d]);
	  	//	  out.println("day="+d+" "+nd[d]);
	  	  }	  	  
	  }
	  all = true;
	  for (int i=1; i<=n; i++)
		  if (need[i] && !have[i]) all = false;
	  if (all) break;
	  res++;
	  dd++;
	  d++;
	  if (d>L) d = 1;
	  
  }
 // for (int x:R) out.println(x+1);
  if (all) {
	  out.println(res);
	  for (int x:R) out.print(x+" ");
  } else out.println("No Solution");
  out.close();    
}   
  
}




