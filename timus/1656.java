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
//        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
//        br = new BufferedReader(new FileReader("input.txt"));      
 //       out= new PrintWriter(new File("output.txt"));
    	br = new BufferedReader(new InputStreamReader(System.in));
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
int n,sz,k;
int[] a;
int[][] d;
void fill(int i) {
	for (int j=sz; j>=0; --j) d[i][j] = a[k--];
	for (int j=sz+1; j<n; j++) d[i][j] = a[k--];
}
public void solve() throws IOException {
	n = nextInt();
	a = new int[n*n];
	for (int i=0; i<n*n; i++) a[i] = nextInt();
	Arrays.sort(a);
	k = n*n-1;
	sz = n/2;
	d = new int[n][n];
	for (int i=sz; i>=0; i--) fill(i); 
	for (int i=sz+1; i<n; i++) fill(i); 
		
	
	for (int i=0; i<n; i++) {
		for (int j=0; j<n; j++)
			out.print(d[i][j]+" ");
		out.println();
	}
}      
} 



















