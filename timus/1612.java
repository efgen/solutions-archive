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
	return ((int)in.nval);
}
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}

String next() throws IOException {
	in.nextToken();
	return in.sval;
}

public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
 // in = new StreamTokenizer(br);
 
  out = new PrintWriter(System.out);
  int a = 0, b = 0;
  while (true) {
	  String s = br.readLine();
	  if (s==null) break;
	  StringTokenizer st = new StringTokenizer(s,".,-:!? ");
	  while (st.hasMoreElements()) {
		  String t = st.nextToken();
		  if (t.equals("tram")) a++; else
			  if (t.equals("trolleybus")) b++;
	  }
  }
  if (a>b) out.print("Tram driver"); else
	  if (a<b) out.print("Trolleybus driver"); else out.print("Bus driver");
  out.close();    
}   

}
