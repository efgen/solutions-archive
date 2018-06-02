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
int mod = 9973;
int[] x3 = new int[mod];
int[] x5 = new int[mod];
public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);
  int[] a = {0,5392,1890,84,6520,3149,2416,2835,80,8614,742,7696,6823,9492,7710,9444,510,118,6522,3213,4499,6178,4565,763,1071,8875,2688,9145,1211,9480,4056,1817,8661,5467,3358,2892,2205,8691,1963,2386,8401,1047,3691,6824,825,7728,6797,1720,8194,9901,2823,1952,9344,5022,1421,6116,4511,1289,2133,7494,7298,5012,9638,8753,5968,4029,4804,9556,924,1497,5886,6078,2085,3876,268,2910,8962,2970,1015,3931,1103,4872,4054,346,1119,931,4454,6530,1722,4266,9888,7961,2891,885,4461,7731,3316,2155,93,2871,9710};
  
  for (int i=0; i<mod; i++) {
	  int x2 = i*i%mod;
	  x3[i] = x2*i%mod;
	  x5[i] = x2*x3[i]%mod;
	  x3[i] = (x3[i]+3*i)%mod;
  }
  int n = nextInt();
  int f = a[n/1000000];
  int x = n/1000000*1000000%mod;  
  int d = 7+mod;
  int d2 = mod-1;
  n %= 1000000;  
  for (int i=1; i<=n; i++) {
	  x++;
	  if (x==mod) x = 0;	  
	  f = ((d2+f)*x5[x]+x3[x]+(d-x)*f)%mod; 	
  }
  out.print(f);
  out.close();    
}   
  
}




