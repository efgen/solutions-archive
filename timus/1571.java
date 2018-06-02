import java.awt.Point;
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
String next() throws IOException {
	in.nextToken();
	return in.sval;
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);  
  out = new PrintWriter(System.out); 
  int n = nextInt();
  Set<String> hs = new HashSet<String>();
  boolean f = true;
  for (int i=0; i<n; i++) {
	  String s = next();
	  if (hs.contains(s)) {if (n!=2)f = false;} else hs.add(s);
  }
  n = hs.size();
  if (!f) out.print("Impossible"); else
	  if (n==1) out.print(0); else 
	  if (n==2) {
		 String[] ss = hs.toArray(new String[0]);
		 out.println(1);
		 out.println(ss[0]+"-"+ss[1]);
	  } else {
		  out.println(n);
		  for (String s:hs) out.println(s+"-huihuihui");		  
	  }	  
  out.close();    
}   
  
}




