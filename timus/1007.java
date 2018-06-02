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
int n;
void show(char[] c, int l, int r) {
	for (int i=l; i<=r; i++) out.print(c[i]);
}
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  n = Integer.parseInt(br.readLine().trim());
  int mod = n+1;
  while (true) {
	  String s = br.readLine();
	  if (s==null) break;
	  s = s.trim();
	  int len = s.length();
	  s = "."+s;
	  if (len<n-1) continue;
	  int[] a = new int[n+3];
	  char[] c = s.toCharArray();
	  for (int i=len; i>0; i--)
		  a[i] = a[i+1]+c[i]-'0';
	  int sum = 0;
	  for (int i=1; i<=len; i++)
		  if (c[i]=='1') sum += i;	  
	  
	  if (len>n) {
		  for (int i=1; i<=len; i++)
			  if (c[i]=='0') {
				  int ss = sum+mod-a[i];
				  if (ss%mod==0) {
					  show(c,1,i-1);
					  show(c,i+1,len);
					  out.println();
					  break;
				  }
			  } else {
				  int ss = sum+mod-a[i]+1-i;
				  if (ss%mod==0) {
					  show(c,1,i-1);
					  show(c,i+1,len);
					  out.println();
					  break;
				  }
			  }			  
		  
	  } else
	  if (len<n) {
		  for (int i=1; i<=len+1; i++) {
			  int ss = sum+mod+a[i];
			  if (ss%mod==0) {
				  show(c,1,i-1);
				  out.print('0');
				  show(c,i,len);
				  out.println();
				  break;
			  }
			  ss += i;
			  if (ss%mod==0) {
				  show(c,1,i-1);
				  out.print('1');
				  show(c,i,len);
				  out.println();
				  break;
			  }
		  }
		 // out.println("---");
	  } else {
		  if (sum%mod==0) {
			  show(c,1,len);
			  out.println();			 
		  } else {
		  for (int i=1; i<=len; i++)
			  if (c[i]=='1') {
				  int ss = sum-i+mod;
				  if (ss%mod==0) {
					  c[i] = '0';
					  show(c,1,len);
					  out.println();
					  break;
				  }
			  }
		  }
	  }
	  
  }

  out.close();    
}   

}




