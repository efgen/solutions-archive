import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StringTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
int nextInt() throws IOException{      
          
    return Integer.parseInt(next());      
}
long nextLong() throws IOException{    
    
    return Long.parseLong(next());      
}      
String next() throws IOException{      
    while (ST==null || !ST.hasMoreTokens()) {
    	String line = br.readLine();
    	if (line==null) return null;
    	ST  = new StringTokenizer(line);
    }
    return ST.nextToken();
}      
double nextD() throws IOException{      
    return Double.parseDouble(next());      
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
    	//in = new Scanner(br);
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
HashMap<Integer, Boolean> odd = new HashMap<Integer, Boolean>();
HashMap<Integer, Integer> prv = new HashMap<Integer, Integer>();
HashSet<Integer> hs = new HashSet<Integer>();
boolean add(int a, int b, boolean f) {
	if (!hs.contains(b)) {
		hs.add(b);
		prv.put(b, a);
		odd.put(b, f);
		return true;	
	}
	int p = prv.get(b);
	if (p==a) return f==odd.get(b);
	
	if (p<a) {
		return add(p, a-1, f^odd.get(b));
	} else {
		return add(a, p-1, f^odd.get(b));
	}
	
}
public void solve() throws IOException {
	while (true) {
		hs.clear();
		prv.clear();
		odd.clear();
		int len = nextInt();
		if (len<0) return;
		int n = nextInt();
		int res = -1;
		for (int i=0; i<n; i++) {
			int a = nextInt();
			int b = nextInt();
			if (b<a) {
				int q = a; a = b; b = q;
			}
			if (a<0 || b>len) {
				next();
				if (res<0) res = i;
				continue;
			}
			if (!add(a, b, next().charAt(0)=='o')) {
				if (res<0) res = i;				
			}
		}
		if (res<0) out.println(n); else out.println(res);
	}
}
  
}













 
 
  