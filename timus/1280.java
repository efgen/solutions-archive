import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
StreamTokenizer st;

public static void main(String[] args) throws IOException {
new Main().run();
}

int nextInt() throws IOException
{
   st.nextToken();
   return (int)st.nval;
}

public void run() throws IOException {
//  in = new Scanner(System.in); in.useLocale(Locale.US);
  st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
 
  out = new PrintWriter(System.out);
  int n = nextInt();
  int m = nextInt();
  Vector[] a = new Vector[n+1];
  for (int i=0; i<=n; i++) a[i] = new Vector();
  int[] r = new int[n+1];
  while  (m-->0) {
	 int x = nextInt();
	 int y = nextInt();
	 r[y]++;
	 a[x].add(y);
  }

  boolean good = true;
  boolean[] f = new boolean[n+1];
  for (int i=1; i<=n && good; i++) {
	  int x = nextInt();
	  f[x] = true;
	  if (r[x]>0) {good = false; break;}
	  Iterator it = a[x].iterator();
	  while (it.hasNext()) {
		  int y = (Integer)it.next();
		  r[y]--;
		  if (f[y]) {good = false; break;}
	  }
  }
  if (good) out.print("YES"); else out.print("NO");  
  //in.close();
  out.close();
}

}


