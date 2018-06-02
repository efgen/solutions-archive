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
const int maxn = 2000;
int a[maxn];
short id[maxn];
short d[maxn][maxn];
int main(){      
   // freopen("input.txt","r",stdin);      
   // freopen("output.txt","w",stdout);    
	int n,x;
	scanf("%d",&n);
	vector< PII > A;
	forn(i,n) {
		scanf("%d",&x);
		A.pb(mp(x,i+1));
	}
	sort(all(A));
	n = 0;
	forv(i,A)
		if (n==0 || (a[n-1]!=A[i].first)) {
			a[n] = A[i].first;
			id[n] = A[i].second;
			n++;
		}
		
		
	forn(i,n) forn(j,n) 
		if (i<j) d[i][j] = 2; else
			if (i==j) d[i][j] = 1; else d[i][j] = 0;
	for (int r=1; r<n; ++r) {
		x = a[r];
		int i = r, j = r-2;
		while (--i>0) {
			while (j>=0 && a[i]-a[j]<x-a[i]) --j;
			if (j<0) break;
		    if (a[i]-a[j]==x-a[i]) {
				if (d[i][r]<d[j][i]+1) 
					d[i][r] = d[j][i]+1;				  			  
		   }		   		
		}
	}

  int res = 0, bi = 0, bj = 0;
  for (int i=0; i<n; i++)
	  for (int j=i; j<n; j++)
		  if (d[i][j]>res) {
			  bi = i;
			  bj = j;
			  res = d[i][j];
		  }
 
  
  cout << res << endl;
  int dd = a[bj]-a[bi];
  while (--res>0) {
	  printf("%d ",id[bj]);	
	  int nn = bi-1;
	  while (nn>=0 && a[bi]-a[nn]!=dd) --nn;
	  bj = bi; bi = nn; 
  }
  printf("%d ",id[bj]);	  
    return 0;      
}  