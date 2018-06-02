import java.io.*;         
import java.util.*;         
import java.math.*;         

public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
int inf = 1000000000;   

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
    	//br = new BufferedReader(new FileReader(new File(filename+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
    //	in = new Scanner(br);
    //    ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}
class Point {
	char c;
	int p;
	Point(char aa, int pp) {
		c = aa; p = pp;
	}
}
class RMQ {
	int[] a, b;
	int p = 1;
	public RMQ(int[] v) {
		int n = v.length;
		while (p<n) p *= 2;
		a = new int[2*p+10];
		b = new int[2*p+10];
		Arrays.fill(b, -1);
		Arrays.fill(a, inf);
		for (int i=0; i<n; i++) a[i+p] = b[i+p] = v[i];
		for (int i=p-1; i>=0; i--) a[i] = Math.min(a[2*i], a[2*i+1]);
		for (int i=p-1; i>=0; i--) b[i] = Math.max(b[2*i], b[2*i+1]);
	}
	int min(int l, int r) {
		l += p; r += p;
		int res = inf;
		while (l<=r) {
			if (l%2==1) res = Math.min(res, a[l]);
			if (r%2==0) res = Math.min(res, a[r]);
			l = (l+1)/2;
			r = (r-1)/2;
		}
		return res;
	}
	
	
	int max(int l, int r) {
		l += p; r += p;
		int res = -1;
		while (l<=r) {
			if (l%2==1) res = Math.max(res, b[l]);
			if (r%2==0) res = Math.max(res, b[r]);
			l = (l+1)/2;
			r = (r-1)/2;
		}
		return res;
	}
	
}
public void solve() throws IOException {
	char[] s = br.readLine().toCharArray();
	int n = s.length;
	Point[] a = new Point[n];
	int k = 0;
	int[] v = new int[n];
	for (int i=0; i<n; i++) {
		char c = s[i];
		if (Character.isLowerCase(c)) {
			if (k>0 && a[k-1].c==c) {
				k--;
				v[i] = a[k].p;
				v[a[k].p] = i;
			}else {			
				v[i] = -1;
				while (k>0) v[a[--k].p] = -1;
			}
		} else 
			a[k++] = new Point((char)(c -'A'+ 'a'), i);		
	}
	while (k>0) v[a[--k].p] = -1;

	RMQ rmq = new RMQ(v);
	int q = Integer.parseInt(br.readLine());
	while (q-->0) {
		String[] ss = br.readLine().split(" ");
		int l = Integer.parseInt(ss[0])-1;
		int r = Integer.parseInt(ss[1])-1;
		int min = rmq.min(l, r);
		int max = rmq.max(l, r);
		if (min>= l && max>=l && min<=r && max<=r) out.print(1); else out.print(0);
	}
	
}
}





