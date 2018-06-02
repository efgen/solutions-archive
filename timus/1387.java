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

int[] a;
BigInteger[] d;
int n,L;
int r = 0;
void Next() {
	r++;
	int i = L-1;
	int s = a[L];
	while (i>1 && a[i-1]==a[i]) {
		s += a[i];
		i--;
	}
	a[i]++;
	L = i+s-1;
	for (int j=i+1; j<=L; j++) a[j] = 1;
}


public void run() throws IOException {  
  br = new BufferedReader(new InputStreamReader(System.in));
  in = new StreamTokenizer(br);
  out = new PrintWriter(System.out);

  int N = nextInt();
  String[] ss = {"0","1","1","2","4","9","20","48","115","286","719","1842","4766","12486","32973","87811","235381","634847","1721159","4688676","12826228","35221832","97055181","268282855","743724984","2067174645","5759636510","16083734329","45007066269","126186554308","354426847597","997171512998","2809934352700","7929819784355","22409533673568","63411730258053","179655930440464","509588049810620","1447023384581029","4113254119923150","11703780079612453","33333125878283632","95020085893954917","271097737169671824","774088023431472074","2212039245722726118","6325843306177425928","18103111141539779470","51842285219378800562","148558992149369434381","425976989835141038353",};
  out.println(ss[N]);
 /* n = N;
  L = n;
  a = new int[n+5];
  d = new BigInteger[n+5];
  Arrays.fill(d, BigInteger.ZERO);
  d[1] = d[2] = BigInteger.ONE;
  
  for (int n=2; n<N; n++) {
	  L = n;
	  for (int i=1; i<=n; i++) a[i] = 1;
	  do {
		  BigInteger t = BigInteger.ONE;
		  int k = 0;
		  for (int i=1; i<=L; i++) {			  
			  if (a[i]==a[i-1]) {
				  k++;
				  t = t.multiply((d[a[i]].add(BigInteger.valueOf(k))));
				  t = t.divide(BigInteger.valueOf(k+1));
			  } else {
				  k = 0;
				  t = t.multiply(d[a[i]]);
			  }
		  }
		  d[n+1] = d[n+1].add(t);
		  Next();
	  } while (L>1);
	  d[n+1]  = d[n+1].add(d[n]);
  }
 out.print(d[N]);
  
  for (int i=0; i<=N; i++) {
	  out.print("\""+d[i]+"\",");
  }*/
  out.close();    
}   

}


