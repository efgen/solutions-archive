import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(System.in); in.useLocale(Locale.US);   
  out = new PrintWriter(System.out);
  int n = 11;
  boolean[][] a = new boolean[n+1][n+1];
  int[] Qx = new int[n*n+1];
  int[] Qy = new int[n*n+1];
  int s = 0, t = 1;
  
  StringTokenizer st = new StringTokenizer(in.nextLine()," ");
  if (st.countTokens()==1) {
	  int k = Integer.parseInt(st.nextToken());
	  for (int i=0; i<k; i++)
		  a[in.nextInt()][in.nextInt()] = true;	
	  int x = 0, y = 0;
	  boolean f = true;
	  for (int i=1; i<n && f; i++)
		  for (int j=1; j<n && f; j++)
			  if (a[i][j]) {
				  x = i;
				  y = j;
				  f = false;			 
			  }
	  out.println(x+" "+y);	
	  Qx[t] = x; Qy[t] = y;
	  a[x][y] = false;
	  while (s<t) {
		  s++;
		  x = Qx[s];
		  y = Qy[s];
		  if (a[x+1][y]) {a[x+1][y] = false; t++; Qx[t]=x+1; Qy[t]=y; out.print("R");}
		  if (a[x][y+1]) {a[x][y+1] = false; t++; Qx[t]=x; Qy[t]=y+1; out.print("T");}
		  if (a[x-1][y]) {a[x-1][y] = false; t++; Qx[t]=x-1; Qy[t]=y; out.print("L");}
		  if (a[x][y-1]) {a[x][y-1] = false; t++; Qx[t]=x; Qy[t]=y-1; out.print("B");}
		  if (s<k) out.println(","); else out.println(".");
	  }
  } else {
	  int x = Integer.parseInt(st.nextToken());
	  int y = Integer.parseInt(st.nextToken());
	  Qx[t] = x; Qy[t] = y;
	  while (s<t) {
		  s++; x = Qx[s]; y = Qy[s]; a[x][y] = true;
		  char[] str = in.nextLine().toCharArray();
		  for (char c:str) {			
			  if (c=='R') {t++; Qx[t]=x+1; Qy[t]=y;}
			  if (c=='T') {t++; Qx[t]=x; Qy[t]=y+1;}
			  if (c=='L') {t++; Qx[t]=x-1; Qy[t]=y;}			 
			  if (c=='B') {t++; Qx[t]=x; Qy[t]=y-1;}
		  }
	  }
	  out.println(t);
	  for (int i=1; i<n; i++)
		  for (int j=1; j<n; j++)
			  if (a[i][j]) out.println(i+" "+j);
	  
  }
  in.close(); out.close();
}

}


