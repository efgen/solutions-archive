#include <string>      
#include <vector>      
#include <cmath>      
#include <queue>      
#include <set>      
#include <map>      
#include <algorithm>      
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
int b[100][100];

int main(){      
   
	scanf("%d%d",&n,&m);
	forn(i,n) forn(j,m) scanf("%d",&a[i][j]);
	int t = 0;
	forn(k,n/2) {		
		int i = 0;
		while (i<m) {
		if (a[2*k][i]==a[2*k+1][i] || a[2*k][i+1]==a[2*k+1][i+1]) {
			b[2*k][i] = b[2*k][i+1] = ++t;			
			b[2*k+1][i] = b[2*k+1][i+1] = ++t;						
		}  else {
			b[2*k][i] = b[2*k+1][i] = ++t;
			b[2*k][i+1] = b[2*k+1][i+1] = ++t;
		}
		i+=2;
		}
	}
	forn(i,n) {forn(j,m) printf("%d ",b[i][j]); printf("\n"); }
	
    return 0;      
}  
