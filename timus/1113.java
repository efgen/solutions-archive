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
  //      br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(System.out);
    //	out = new PrintWriter(new File("output.txt"));
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
	double n = nextInt();
	double m = nextInt();
	int a = 0;
	double d = 0, o = 0, w = 0;
	while (true) {
		a++;
		d = m/(2*a-1);
		if (w+d>=n) break;
		w += d;
		o += m;
	}
	

	d = n-w;
	o=o+d*(a*2-1);
	out.print(Math.round((o+0.49999999999)));

	
}      
} 
