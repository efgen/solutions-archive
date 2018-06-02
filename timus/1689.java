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

public void solve() throws IOException {
	int n = nextInt();
	int w = nextInt();
	int B = nextInt();
	int P = nextInt();
	int m = nextInt();
	int[] a = new int[n];
	int[] h = new int[n];
	int[] t = new int[n];
	while (m-->0) {
		int x = nextInt();
		h[x]++; t[x+w-1]++;
	}
	boolean pizdec = w>B-2*P;
	if (pizdec) P = B;
	int res = 0;
	for (int i=0; i<P; i++) res += h[i];
	a[0] = res;
	for (int i=1; i<=n-P; i++) {
		res -= t[i-1];
		res += h[i+P-1];
		a[i] = res;		         
	}
	if (pizdec) {
		res = 0;
		for (int i=0; i<=n-P; i++)
			if (a[i]<a[res]) res = i;
		out.println(res);
		return;
	}
	
	int min = Integer.MAX_VALUE;
	res = 0;
	for (int i=0; i<=n-B; i++) {
		int r = a[i] + a[i+B-P];
		if (r<min) {
			min = r;
			res = i;
		}
	}
	out.print(res);
	
}
} 











