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

int[] a = {0,2,2,3,6,21,231,26796};
public void solve() throws IOException {
	int n = nextInt();
	if (n<=1) {
		out.print(0);
		return;
	}
	for (int k=1; k<a.length; k++) {
		int x = n;
		int i = k;
		while (i>0) {
			int m = a[i--];
			x = Math.max(x/m+x%m, x/m+m-2);
		}
		if (x==1) {
			out.println(k);
			for (i=k; i>0; --i) out.println(a[i]);
			return;
		}
	}
	
}      
} 












