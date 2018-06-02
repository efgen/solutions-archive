import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
Scanner in;
PrintWriter out;
int inf = 1000000000;

public static void main(String[] args) throws IOException {
new Main().run();
}

public void run() throws IOException {
  in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); in.useLocale(Locale.US);
  out = new PrintWriter(System.out);
  String[] map = 
  		  {"7_klyuchey Sortirovochnaya China_town Zarechny City 1905_year_square Kuybyshevskaya Sibirskaya Siniye_kamni Lechebnaya Varshavskaya Kompressornaya Koltsovo",
		  "Pobedy I_Pyatiletki_square Zvezda Uralskaya Shevchenko Teatralnaya Kuybyshevskaya Oborony_square Mayakovskaya Parkovaya Botanicheskaya Samolyotnaya Vtorchermet Keramicheskaya",
		  "Bakinskih_Komissarov Prospekt_Kosmonavtov Uralmash Mashinostroiteley Uralskaya Dinamo 1905_year_square Geologicheskaya Bazhovskaya Chkalovskaya Botanicheskaya Shcherbakovskaya Uktusskie_Gory Nizhne_Isetskaya Himmash",
		  "Taganskaya Elmash Turbinnaya Pionerskaya Shevchenko 1905_year_square Moskovskaya Central_stadium Kraulya Metallurgov MEGA",
		  "Kalinovskaya Italyanskaya Ozyornaya Shefskaya Komsomolskaya Gagarinskaya Teatralnaya Geologicheskaya Posadskaya Volgogradskaya Yugo_zapadnaya Akademicheskaya",
		  "Vilonovskaya Gagarinskaya Vostochnaya Kuybyshevskaya Geologicheskaya Dvorets_sporta Aviatsionnaya Voennaya Sovhoznaya",
		  "Zelyony_ostrov Tatishchevskaya Verh_Isetskaya Kommunarov_square 1905_year_square Teatralnaya Vostochnaya Vtuzgorodok Kamennye_palatki University",
		  "Uralskaya Pionerskaya Gagarinskaya Vtuzgorodok Sibirskaya Oborony_square Bazhovskaya Dvorets_sporta Posadskaya Moskovskaya Kommunarov_square City Uralskaya"};
  HashMap<String,Integer> dict = new HashMap<String,Integer>();
  int n = 0;
  for (String s:map) {
	  Scanner sc = new Scanner(s);
	  while (sc.hasNext()) {
		  String ss = sc.next();
		  if (!dict.containsKey(ss)) dict.put(ss, n++);
	  }
  }
  int[][] a = new int[n][n];
  for (int[] aa:a) Arrays.fill(aa, inf);
  for (int i=0; i<n; i++) a[i][i] = 0;
  for (String s:map) {
	  Scanner sc = new Scanner(s);
	  int x = -1, y = -1;
	  while (sc.hasNext()) {
		  String ss = sc.next();
		  y = dict.get(ss);
		  if (x>=0) a[x][y] = a[y][x] = 1;
		  x = y;
	  }
  }
  for (int k=0; k<n; k++)
	  for (int i=0; i<n; i++)
		  for (int j=0; j<n; j++)
			  a[i][j] = Math.min(a[i][j], a[i][k]+a[k][j]);
  int t = in.nextInt();
  while (t-->0) {
	  int x = dict.get(in.next());
	  int y = dict.get(in.next());
	  out.println(a[x][y]);
  }
  in.close(); out.close();  
}
}
