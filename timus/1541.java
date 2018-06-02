import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";
	int[] V = new int[21];
	int ans = -1;
	long gcd(long a, long b) {
		if (b==0) return a; else return gcd(b, a%b);
	}
	boolean go(long n, long m, int k) {
		if (k==20) return false;
		for (int v=V[k-1]+1; v<=1000; v++) {
			long nn = n*v-m;
			if (nn<0) continue;
			if (nn==0) {
				V[k] = v;
				ans = k;
				return true;
			}
			long mm = m*v;
			long d = gcd(nn, mm);
			V[k] = v;
			if (nn==d)  if (mm/d<=100000 && mm/d>v){
				ans = k+1;
				V[k+1] = (int)(mm/d);
				return true;
			} 
			if (go(nn/d, mm/d, k+1)) return true;
		}
		return false;
	}
    void solve() throws IOException {
    	/*for (int i=1; i<50; i++) for (int j=1*3; j>0; --j) if (go(j, i, 1)) {
    		//out.print(j+" "+i+" "+ans+": ");
    		//while (ans>0) out.print(V[ans--]+" "); out.println();
    		if (ans==0) out.println("FAIL");
    	} else out.println("FAIL"); */
    	/*for (int i=1; i<=50; i++)
    		for (int j=3*i; j>0; --j) {
    			ans = -1;
    			go(j, i, 1);
    			out.print(j+"/"+i+":");    			
    			while (ans>0) out.print(V[ans--]+" "); out.println();
    		}
    		*/	
    	
    		
    		
    	go(nextInt(), nextInt(), 1);
    	out.println(ans);
    	for (int i=ans; i>0; i--) out.print(V[i]+" "); 
    	
    }
    
    


    static final int inf = 1000000000;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
            //br = new BufferedReader(new FileReader(FileName+".in"));
            //out = new PrintWriter(FileName+".out");
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //br = new BufferedReader(new FileReader("input.txt"));
            //out = new PrintWriter("output.txt");
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                    return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
       return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
            return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
            return Long.parseLong(next());
    }

    public static void main(String[] args) {        
            new Task().run();
    
    }
}