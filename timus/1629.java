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
     //   br = new BufferedReader(new FileReader("input.txt"));      
    	br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(System.out);      
        in = new Scanner(br);   
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();              
    }         
    catch (IOException e) {        
    throw new IllegalStateException(e);       
    }      
}   
int val(String s) {
	return ((s.charAt(0)-'0')*10+s.charAt(1)-'0')*60+(s.charAt(3)-'0')*10+s.charAt(4)-'0';
}
public void solve() throws IOException {
	int n = Integer.parseInt(br.readLine());
	int time = 0;
	for (int i=1; i<n; i++) {
		String[] ss = br.readLine().split(" ");
		int q = Integer.parseInt(ss[0]);
		int d = Integer.parseInt(ss[1]);
		int fly = Integer.parseInt(ss[2]);
		ss = br.readLine().split(" ");
		int time2 = inf;
		int hm = time%1440;
		int day = time/1440;
		for (int j=0; j<q; j++) {
			int t = val(ss[j]);
			int tt = t + d;
			tt %= 1440;
			int r = 0;
			if (day==0 && t>tt) {
				r = 1440;
			}			
			if (tt>=hm) {
				time2 = Math.min(time2, r+time+(tt-hm)+fly);
			} else {
				time2 = Math.min(time2, r+time+(tt+1440-hm)+fly);
			}				
				
		}
		time = time2;
		
		
	}
	out.println(time);
	
}      
} 
