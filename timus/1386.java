import java.io.*;   
  
public class Main{     
StreamTokenizer in;  
BufferedReader br;
PrintWriter out;   


public static void main(String[] args) throws IOException {   
    new Main().run();   
}  

int nextInt() throws IOException {
	in.nextToken();
	return ((int)in.nval)-1;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int n = nextInt()+1;
  int m = nextInt()+1;
  int N = n*m;
  int sz = 4*N;
  int[] a = new int[sz];  
  for (int i=0; i<sz; i++) a[i] = nextInt()*m+nextInt();
  int cc = nextInt()+1;
  int[] C = new int[cc];
  for (int i=0; i<cc; i++) C[i] = nextInt()*N;
  boolean[][] f = new boolean[n][m];
  int res = 0;  
  for (int s=0; s<N; s++) {	
	  int v = s;		 
	  for (int p:C) v = a[v+p];
	  int x = v/m;
	  int y = v%m;
	  if (!f[x][y]) {
		  f[x][y] = true;
		  res++;
	  }
  }
  out.println(res);
  for (int i=0; i<n; i++)
	  for (int j=0; j<m; j++)
		  if (f[i][j])
			  out.println((i+1)+" "+(j+1));
  out.close();    
}   

}


