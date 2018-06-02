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
 //       br = new BufferedReader(new FileReader("input.txt"));      
 //      out= new PrintWriter(new File("output.txt"));
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


public void solve() throws IOException {
	int n = nextInt();
	int[] a = new int[n+1];
	for (int i=1; i<=n; i++) a[i] = nextInt();
	int[] ra = new int[n+1];
	int[] rb = new int[n+1];
	for (int i=1; i<=n; i++)  {
		int x = i;
		for (int j=1; j<i; j++) if (a[j]<a[i]) x--;
		ra[a[i]] = x;
		x = n;
		for (int j=i+1; j<=n; j++) if (a[j]<a[i]) x--;
		rb[a[i]] = x;
	}
	for (int i=1; i<=n; i++) out.println(ra[i]+" "+rb[i]);
	

}      
} 



















