import java.io.*;
import java.util.*;
import java.math.*;

public class Task {
	static final String FileName = "test";  
 
    		
    
    void solve() throws IOException {   
    	char[] s = ("0"+next()).toCharArray();
    	char[] t = next().toCharArray();
    	int n = t.length;
  
    	boolean amb = false;
    	for (int i=0; i<n; i++) {
    		if (s[i]!='?') {
	    		if (s[i+1]!='?' && t[i]!='?') {
	    			if (((s[i+1]-'0')^(s[i]-'0')^(t[i]-'0'))!=0) {
	    				out.print("Impossible");
	    				return;
	    			}
	    		} else
	    		if (s[i+1]!='?' && t[i]=='?') {
	    			t[i] = (char)('0'+((s[i]-'0')^(s[i+1]-'0')));
	    		} else
	    		if (s[i+1]=='?' && t[i]!='?') {
	        		s[i+1] = (char)('0'+((s[i]-'0')^(t[i]-'0')));
	        	} 
    		} else {
    			if (s[i+1]!='?' && t[i]!='?') {
    				s[i] = (char)('0'+((s[i+1]-'0')^(t[i]-'0')));	    		
	    		} 
    		}    		
    	}
    	for (int i=n-1; i>=0; --i) {
    		if (s[i]!='?') {
	    		if (s[i+1]!='?' && t[i]!='?') {
	    			if (((s[i+1]-'0')^(s[i]-'0')^(t[i]-'0'))!=0) {
	    				out.print("Impossible");
	    				return;
	    			}
	    		} else
	    		if (s[i+1]!='?' && t[i]=='?') {
	    			t[i] = (char)('0'+((s[i]-'0')^(s[i+1]-'0')));
	    		} else
	    		if (s[i+1]=='?' && t[i]!='?') {
	        		s[i+1] = (char)('0'+((s[i]-'0')^(t[i]-'0')));
	        	} 
    		} else {
    			if (s[i+1]!='?' && t[i]!='?') {
    				s[i] = (char)('0'+((s[i+1]-'0')^(t[i]-'0')));	    		
	    		} 
    		}    		
    	}
    	
    	for (int i=1; i<=n; i++) amb |= s[i]=='?' || t[i-1]=='?'; 
    	if (amb) out.println("Ambiguity"); else {
    		for (int i=1; i<=n; i++) out.print(s[i]);
    		out.println();
    		for (int i=0; i<n; i++) out.print(t[i]);
    		out.println();
    	}
    	
    	
    }
   
    


    static final int inf = 1000000000;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    
    public void run() {
        try {
           // br = new BufferedReader(new FileReader(FileName+".in"));
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