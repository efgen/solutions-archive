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
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
    //	br = new BufferedReader(new FileReader("input.txt"));      
     //  out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
  //  	out = new PrintWriter(System.out);    	
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}

class Point implements Comparable {
	int x,y,id;
	Point (int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public int compareTo(Object o) {
		Point p = (Point) o;
		if (x==p.x) return p.y-y;
		return x-p.x;
	}
	public String toString() {
		return x+" "+y;	
	}
}
int kos(Point a, Point b, Point o) {
	return (a.x-o.x)*(b.y-o.y)-(a.y-o.y)*(b.x-o.x);
}
public void solve() throws IOException {
	int n = nextInt();
	Point[] a = new Point[n];
	Point[] b = new Point[n];
	for (int i=0; i<n; i++) a[i] = new Point(nextInt(),nextInt(),i);
	int res = 0;
	boolean[] f = new boolean[n];
	Arrays.sort(a,0,n);
	while (n>2) {
		b[0] = a[0];
		b[1] = a[1];
		int k = 2;
		boolean ok = false;
		for (int i=2; i<n; i++) {
			while (k>1 && kos(a[i],b[k-1],b[k-2])>0) k--;
			b[k++] = a[i]; 
		}
		for (int i=2; i<k; i++)
			if (kos(b[i],b[i-1],b[i-2])!=0) ok = true;
		for (int i=0; i<k; i++) f[b[i].id] = true;
	
		k = 2;
		b[0] = a[n-1];
		b[1] = a[n-2];
		for (int i=n-3; i>=0; i--) {
			while (k>1 && kos(a[i],b[k-1],b[k-2])>0) k--;
			b[k++] = a[i]; 
		}
		for (int i=2; i<k; i++)
			if (kos(b[i],b[i-1],b[i-2])!=0) ok = true;
		for (int i=0; i<k; i++) f[b[i].id] = true;
		k = 0;
		for (int i=0; i<n; i++)
			if (!f[a[i].id]) {
				b[k++] = a[i];
			}
		n = k;
		for (int i=0; i<n; i++) a[i] = b[i];		
		if (!ok) break;
		res++;
		Arrays.fill(f, false);
	}
	out.println(res);
	
	
}      
} 



















