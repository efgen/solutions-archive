#include <string>      
#include <vector>      
#include <cmath>      
   
    
#include <iostream>      
#include <cstdio>      
#include <sstream>      
  
#define sz(a) ((int)(a).size())   
#define forn(i, n) for (int i = 0; i < (int)(n); ++i)      
#define forv(i, v) for (int i = 0; i < sz(v); ++i)      
#define fors(i, s) for (int i = 0; i < (int)(s.length()); ++i)      
#define fe(it,a) for(typeof(a.begin()) it = a.begin(); it != a.end(); it++)   
#define all(a) (a).begin(), (a).end()      
#define pb push_back      
#define PII pair<int, int>      
#define mp make_pair      
#define VI vector<int>      
#define VS vector<string>   
#define LL long long 
#define min(a,b) ((a<b):a:b)   
using namespace std;      

int n,m;
int a[100][100];
int ans[10000];
int d[100];
int t = 0;
void dfs(int v) {
	for (int i=1; i<=n; i++)
		if (a[v][i]) {
			if (v>0 && i>0) ans[a[v][i]] = ++t;
			a[v][i] = a[i][v] = 0;
			dfs(i);		
		}
}

int main(){      
   
	cin >> n >> m;
	forn(i,n+1) d[i] = 0;
	for (int i=1; i<=m; i++) {
		int x,y;
		scanf("%d%d",&x,&y);
		d[x]++; d[y]++;
		a[x][y] = a[y][x] = i;	
	}
	int res = 0;
	for (int i=1; i<=n; i++)
		if (d[i]&1)  {
			res++;
			a[0][i] = a[i][0] = m+1;			
		}
	if (res==0) {		
		dfs(1);
	} else {		
		dfs(0);	
	}
	cout << "YES" << endl;
	for (int i=1; i<=m; i++) cout << ans[i] << " ";
    return 0;      
}  
