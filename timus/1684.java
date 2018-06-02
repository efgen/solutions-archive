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
	String s1 = br.readLine();
	String s2 = br.readLine();
	char[] a = ("."+s1+"."+s2).toCharArray();
	int n = a.length;
	int[] p = new int[n];
	int q = 0;
	for (int i=2; i<n; i++) {
		while (q>0 && a[i]!=a[q+1]) q = p[q];
		if (a[i]==a[q+1]) q++;
		p[i] = q;
	}
	boolean ok = true;
	int m = s2.length();
	for (int i=1; i<=m; i++) ok &= p[p.length-i]>0;
	if (!ok) out.println("Yes"); else {
		out.println("No");
		Stack<String> st = new Stack<String>();
	
		int pos = p.length-1;
		while (pos>s1.length()+1) {
			StringBuilder sb = new StringBuilder();
			int x = pos-p[pos];
			for (int i=x+1; i<=pos; i++) sb.append(a[i]);
			st.add(sb.toString());	
			pos = x;
		}
		while (!st.isEmpty()) {
			out.print(st.pop()+" ");
		}
	}
	//for (int i=0; i<p.length; i++) out.print(p[i]+" ");
}
} 












