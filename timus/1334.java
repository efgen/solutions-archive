import java.io.*;         
import java.util.*;         
import java.math.*;         

        
public class Main implements Runnable  {   
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;   
int inf = 1000000000;   
double eps = 1e-11;

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

int[] dx = {1, 1, -1, -1};
int[] dy = {1, -1, 1, -1};
public void solve() throws IOException {
	int[][] a =  new int[12][12];
	for (int[] aa:a) Arrays.fill(aa, 1);
	for (int i=0; i<8; i++)
		for (int j=-0; j<8; j++)
			a[i+2][j+2] = 0;
	for (int k=0; k<32; k++) {
		String ss = br.readLine();
		int x = ss.charAt(0)-'a'+2;
		int y = ss.charAt(1)-'1'+2;
		a[x][y] = 1+(k%2);
		boolean f = false;
		for (int i=2; i<10; i++)
			for (int j=2; j<10; j++)
				for (int t=0; t<4; t++)
					if (a[i+2*dx[t]][j+2*dy[t]]==0 && a[i+dx[t]][j+dy[t]]+a[i][j]==3) f = true;
		if (f) {
			out.println(k+1);
			return;
		}
	}
	out.println("Draw");
}
}







