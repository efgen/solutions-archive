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
double nextD() throws IOException {
	in.nextToken();
	return in.nval;
}
long nextLong() throws IOException {
	in.nextToken();
	return (long)in.nval;
}
int nextInt() throws IOException {
	in.nextToken();
	return (int)in.nval;
}
String next() throws IOException {
	in.nextToken();
	return in.sval;
}
int k = 1;
void add(int x) {
	out.println((k++)+" "+x);
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);   
  int n = nextInt();
  int m12 = n%12;
  if (m12==2) {
	  for (int i=2; i<=n; i+=2) add(i);
	  add(3); add(1);
	  for (int i=7; i<=n; i+=2) add(i);
	  add(5);	  
  } else 
  if (m12==3 || m12==9) {
	  for (int i=4; i<=n; i+=2) add(i); add(2);
	  for (int i=5; i<=n; i+=2) add(i); add(1); add(3);
  } else
  if (m12==8) {
	  for (int i=2; i<=n; i+=2) add(i);
	  for (int i=3; i<=n; i+=4) { add(i); add(i-2);}
  } else {
	  for (int i=2; i<=n; i+=2) add(i);
	  for (int i=1; i<=n; i+=2) add(i);
  }
  out.close();    
}   
  
}




