import java.io.*;
import java.util.*;
import java.math.*;

public class Main {	
StreamTokenizer in;
PrintWriter out;
int n,m;
int[] al,ar,az,br,bl;


public static void main(String[] args) throws IOException {
	new Main().run();
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}


public void run() throws IOException {
  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); 
  out = new PrintWriter(System.out);
  n = nextInt();
  al = new int[n+1];
  ar = new int[n+1];
  az = new int[n+1];
  for (int i=1; i<=n; i++) {
	  al[i] = nextInt();
	  ar[i] = nextInt();
	  az[i] = nextInt();
  }
  m = nextInt();
  bl = new int[m+2];
  br = new int[m+2];
  for (int i=1; i<=m; i++) {
	  br[i] = nextInt();
	  bl[i+1] = nextInt();
	  in.nextToken();
  }
  bl[1] = -33000;
  br[m+1] = 33000; m++; 
  int i = 1, j = 1, k = 0,ll,rr;
  Vector L = new Vector();
  Vector R = new Vector();
  Vector Z = new Vector();
 // String s = "";
  while (i<=n && j<=m) {	
	  if (al[i]>bl[j]) ll = al[i]; else ll = bl[j];
	  if (ar[i]<br[j]) rr = ar[i]; else rr = br[j];	 
	  if (ll<rr) {
		  k++;
		  L.add(ll);
		  R.add(rr);
		  Z.add(az[i]);
		//  s += " "+ll+" "+rr+" "+az[i]; 
	  }
	  if (ar[i]<br[j]) i++; else j++;	   
  }
  out.print(k);
  Iterator LI = L.iterator();
  Iterator RI = R.iterator();
  Iterator ZI = Z.iterator();
  while (k-->0) 
	  out.print(" "+LI.next()+" "+RI.next()+" "+ZI.next());  
  out.close();
}

}

