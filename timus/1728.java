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
    	//br = new BufferedReader(new FileReader(new File(filename+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename+".out"))));
    	
    	
    	//br = new BufferedReader(new FileReader(new File("input.txt")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
    	
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    	
    	
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
	int n = Integer.parseInt(br.readLine());
	TreeSet<String> c3 = new TreeSet<String>(); 
	TreeSet<String> c2 = new TreeSet<String>(); 
	while (n-->0) {
		String[] ss = br.readLine().split(" ");
		int t = Integer.parseInt(ss[0]);
		for (int i=1; i<=t; i++) {
			if (ss[i].equals("Efremov") || ss[i].equals("Kantorov")) continue;
			if (t==3) c3.add(ss[i]); else c2.add(ss[i]);
		}
	}
	String[] ss = br.readLine().split(" ");
	int re = Integer.parseInt(ss[0]);
	int rk = Integer.parseInt(ss[1]);
	n = Integer.parseInt(br.readLine());
	int res = -1;
	String name  = "";
	while (n-->0) {
		ss = br.readLine().split(" ");
		int r = Integer.parseInt(ss[1]);
		if (!c3.contains(ss[0])) {
			if (re+rk+r>res) {
				res = re+rk+r;
				name = ss[0];
			}
		} else
			if (!c2.contains(ss[0])) {
				if (rk+r>res) {
					res = rk+r;
					name = ss[0];
				}
			}
	}
	if (res>=0) {
		out.println("Win");
		out.println(name);
	} else out.println("Fail");
	
}
}





