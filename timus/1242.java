import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

Scanner in;
PrintWriter out;
Vector[] p,c;
boolean[] f;
public static void main(String[] args) throws IOException {
new Main().run();
}

void SolvP(int v){
		f[v] = true;
		Iterator it = p[v].iterator();
		while (it.hasNext()) SolvP((Integer)it.next());

}
void SolvC(int v){
		f[v] = true;
		Iterator it = c[v].iterator();
		while (it.hasNext()) SolvC((Integer)it.next());

}
public void run() throws IOException {
  in = new Scanner(System.in);
  out = new PrintWriter(System.out); 
  int n = in.nextInt();
  p = new Vector[n+1];
  c = new Vector[n+1];
  f = new boolean[n+1]; 
  for (int i=1; i<=n; i++) {
	  p[i] = new Vector();
	  c[i] = new Vector();
  }
  while (in.hasNextInt()) {
	  int ch = in.nextInt();
	  int pr = in.nextInt();
	  p[ch].add(pr);
	  c[pr].add(ch);
  }
  in.nextLine(); in.nextLine();
  while (in.hasNextInt()) {
	  int v = in.nextInt();
	  SolvP(v);
	  SolvC(v);	  
  }
  boolean fl = true;
  for (int i=1; i<=n; i++) 
	  if (!f[i]) {
		  out.print(i+" ");
		  fl = false;
	  }
  if (fl) out.print(0);  
  in.close();  out.close();
}

}