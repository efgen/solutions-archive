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
  Vector<Integer> PC = new Vector<Integer>();
  while (in.hasNextInt()) 
	  PC.add(in.nextInt());
  int n = PC.size()+1;
  TreeSet[] sp = new TreeSet[n+1];
  int[] a = new int[n+1];
  for (int i=1; i<=n; i++) sp[i] = new TreeSet();
  for (Iterator it = PC.iterator(); it.hasNext();) {
	  Integer x = (Integer) it.next();
	  a[x]++;	
  }
  for (Iterator it = PC.iterator(); it.hasNext();) {
	  Integer x = (Integer) it.next();
	  int y = 0;
	  for (y=1; y<=n && a[y]>0; y++);
	  a[x]--; a[y]++;
	  sp[x].add(y);
	  sp[y].add(x);
  }
  for (int i=1; i<=n; i++) {
	  out.print(i+":");
	  for (Iterator it = sp[i].iterator(); it.hasNext();) {
		Integer x = (Integer) it.next();
		out.print(" "+x);		
	  }
	  out.println();
  }
  

  in.close();  out.close();
}

}


