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
	int n = nextInt();
	int m = 5*n;
	ArrayList<Integer>[] a = new ArrayList[4];
	for (int i=0; i<4; i++) a[i] = new ArrayList<Integer>();
	out.println("OK");
	for (int i=1; i<=m; i++) {
		int x = nextInt()&1;
		int y = nextInt()&1;
		if (x==0) {
			if (y==0) a[0].add(i); else a[1].add(i); 
		} else {
			if (y==0) a[2].add(i); else a[3].add(i);
		}
	}
	int t = 0;
	for (int i=1; i<4; i++) if (a[i].size()>a[t].size()) t = i;
	for (int i=0; i<n; i++) out.print(a[t].get(i)+" ");
	
}
  
}
















 
 
  