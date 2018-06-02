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
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  out = new PrintWriter(System.out);
  TreeSet<String> t = new TreeSet<String>();  
  t.add("sun");
  while (true) {
	  String s = br.readLine();
	  if (s==null) break;	
	  if ( s.charAt(0)=='+') t.add(s.substring(1)); else {
		  s = s.substring(1);
		  out.println(s);		  
		  SortedSet<String> tt = t.subSet(s, s+"zzzzzzzzzzzzzzzzzzz");
		  if (t==null) continue;
		  int k = 0;
		  for (Iterator it = tt.iterator(); it.hasNext() && k<20;) {
			String r = (String) it.next();
			out.print("  ");
			out.println(r);
			k++;			
		}		 
	  }
  }
  out.close();    
}   
  
}




