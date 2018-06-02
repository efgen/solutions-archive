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
int[] p, rank;
int find(int x) {
	if (x!=p[x]) p[x] = find(p[x]);
	return p[x];
}
void link(int x, int y) {
	if (rank[x]<rank[y]) p[x] = y; else {
		p[y] = x;
		if (rank[x]==rank[y]) rank[x]++;
	}
}
public void solve() throws IOException {
	int n = nextInt();
	TreeSet<Integer>[] a = new TreeSet[n];
	for (int i=0; i<n; i++) a[i] = new TreeSet<Integer>();
	for (int i=0; i<n; i++) {
		a[(int)((1l*i*i)%n)].add(i);
		a[i].add((int)((n-1l*i*i%n)%n));
	}
	int m = 4*n;
	p = new int[m];
	rank = new int[m];
	for (int i=0; i<m; i++) p[i] = i;
	for (int i=2; i<m; i++) {
		int ost = (n-i%n)%n;
		for (int x:a[ost]) {
			int y = x;
			if (y==0) y += n;
			while (y<i) {
				int px = find(i);
				int py = find(y);
				if (px==py) {
					out.println(i);
					return;
				}
				link(px,py);
				y += n;
			}
		}
	
		
		
	}
}
} 












