import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;
public static void main(String[] args) throws IOException {
new Main().run();
}
String s;
int[][] a,w;
int n;
String show(int L, int R) {
	if (L>R) return "";
	if (s.charAt(L)==')') return "()"+show(L+1,R);
	if (s.charAt(L)==']') return "[]"+show(L+1,R);
	if (s.charAt(R)=='(') return show(L,R-1)+"()";
	if (s.charAt(R)=='[') return show(L,R-1)+"[]";
	if (w[L][R]==-1) return s.charAt(L)+show(L+1,R-1)+s.charAt(R);
	return show(L,w[L][R])+show(w[L][R]+1,R);
}
public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  s = "";
  if (in.hasNext()) s = in.next();
  n = s.length();
  a = new int[n][n];
  w = new int[n][n];
  for (int i=0; i<n; i++) {
	  a[i][i] = 2;
	  w[i][i] = -1;
  }
  
  for (int len=2; len<=n; len++)
	  for (int L=0,R = len-1;R<n; L++, R++) { 
		  if (s.charAt(L)==')' || s.charAt(L)==']') {
			  a[L][R] = 2+a[L+1][R];
			  continue;
		  }
		  if (s.charAt(R)=='(' || s.charAt(R)=='[') {
			  a[L][R] = 2+a[L][R-1];
			  continue;
		  }
		  a[L][R] = inf;
		  int best = -1;
		  for (int E=L; E<R; E++) {
			  if (a[L][E]+a[E+1][R]<a[L][R]) {
				  best = E;
				  a[L][R] = a[L][E]+a[E+1][R];
			  }
		  }
		  if ((s.charAt(L)=='(' && s.charAt(R)==')')||(s.charAt(L)=='[' && s.charAt(R)==']')) {
			  if (a[L+1][R-1]+2<a[L][R]) {
				  best = -1;
				  a[L][R] = a[L+1][R-1]+2;
			  }
		  }
		  w[L][R] = best;		  
	  }		
  //out.println(a[0][n-1]);
  out.println(show(0,n-1));
  in.close(); out.close();  
}
}


