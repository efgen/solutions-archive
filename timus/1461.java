import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}
long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
   new Thread(new Main()).start();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
    	in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}


public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	char[] s = ("h"+br.readLine()).toCharArray();
	n++;
	int[] a = new int[n];
	for (int i=0; i<n; i++) if (s[i]=='u') a[i] = 1; else if (s[i]=='d') a[i] = -1;
	int[] h = new int[n];
	n--;
	for (int i=1; i<=n; i++) {
		h[i] = h[i-1]+a[i];
	}
	boolean ok = false;
	for (int i=n; !ok && i>0; --i) {
		int len = n-i;
		for (int x=a[i]+1; !ok && x<=1; x++) {
			int nh = h[i-1]+x;
			if (nh<0) continue;
			if (nh==h[i-1] && nh==0) continue;
			if (nh>len) continue;
			int t = len-nh;
			if (t%2==0) {
				ok = true;
				a[i] = x;
				for (int j=1; j<=nh; j++) a[i+j] = -1;
				for (int j=1; j<=t; j+=2) {
					a[i+nh+j] = 1;
					a[i+nh+j+1] = -1;
				}
			} else {
				if (t==1) {
					if (nh==0) continue;
					ok = true;
					a[i] = x;
					for (int j=1; j<nh; j++) a[i+j] = -1;
					a[i+nh] = 0;
					a[i+nh+1] = -1;
				} else {
					ok = true;
					a[i] = x;
					for (int j=1; j<=nh; j++) a[i+j] = -1;
					for (int j=1; j<=t-3; j+=2) {
						a[i+nh+j] = +1;
						a[i+nh+j+1] = -1;
					}
					t = i+nh+t-2;
					a[t] = 1;
					a[t+1] = 0;
					a[t+2] = -1;
				}
			}
		}
	}
	if (!ok) {
		out.println("No solution");
		return;
	}
	for (int i=1; i<=n; i++) if (a[i]==1) out.print('u'); else if (a[i]==-1) out.print('d'); else out.print('h');
	
}
  
}













 
 
  