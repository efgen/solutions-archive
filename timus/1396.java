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
      //  br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        //out= new PrintWriter(new File("output.txt"));
    	out = new PrintWriter(System.out);
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

long f(long n) {
	long a = 1, b = 0;
	while (n>1) {
		if (n%2==0) 
			a += b;
		else 
			b += a;
		n >>= 1;
	}
	return a+b;
}
int find(long[] a, int l, int r, long x) {
	while (l<r) {
		int mid = (l+r+1)>>1;
		if (a[mid]>x) r = mid-1; else l = mid;
	}
	return r;
}
public void solve() throws IOException {
	PriorityQueue<Long> q = new PriorityQueue<Long>();
	q.add(1l);
	long[] a = new long[10000];
	int k = 0;
	long r = 0, lastr = 0;
	long g = 1000000000000000000l;
	while (!q.isEmpty()) {
		long x = q.poll();
		if (x>g) break;
		r = f(x);
		if (r>lastr) {
			lastr = r;
			a[k++] = x;
			if (2*x-1<=g) q.add(2*x-1);
			if (2*x+1<=g) q.add(2*x+1);
			if (4*x-1<=g) q.add(4*x-1);
			if (4*x+1<=g) q.add(4*x+1);
		}		
	}
	while (true) {
		long x = Long.parseLong(br.readLine());
		if (x==0) return;
	//	int p = Arrays.binarySearch(a, 0, k, x);
		//if (p<0) p = -p-2;
		int p = find(a,0,k-1,x);
		out.println(f(a[p]));
	}	
} 

}










