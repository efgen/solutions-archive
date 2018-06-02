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
const int  inf = 1000000000;   
using namespace std;      
const int maxn = 40;
LL sz = ((LL)1) << 32;
LL msk = sz-1;
struct num {
	unsigned int a[4];
	void mul(LL x) {
		LL um = 0;
		for (int i=0; i<4; i++) {
			um = a[i]*x+um;
			a[i] = (unsigned int)(um&msk);
			um >>= 32;
		}
	}
	
} a[maxn],data[5000];
inline bool cmp(num &x, num &y)  { // <
	for (int i=3; i>=0; --i) 
		if (x.a[i]<y.a[i]) return true; else
			if (x.a[i]>y.a[i]) return false; 
	return false;
}
int hbit[1<<16];
int log10_2[128];
int msk2 = (1<<16)-1;
int main(){      
   // freopen("input.txt","r",stdin);      
   // freopen("output.txt","w",stdout);    
	long double d = 1; log10_2[0] = 0;
	for (int i=1; i<128; i++) {
		d *= 2;
		log10_2[i] = floor(log10(d));	
	}
	
	int t = 0;
	for(int i=1; i<1<<16; i++) {
		if (i>>t) hbit[i] = ++t; else hbit[i] = t;
	}
	memset(a,0,sizeof(a));
	a[0].a[0] = 1;
	for(int i=1; i<maxn; i++) {	
		a[i] = a[i-1];
		a[i].mul(10);
	}

	int n;
	scanf("%d",&n);
	forn(i,n) {
		for (int j=3; j>=0; --j) 
			scanf("%ld",&data[i].a[j]);
	}
	
	int RES = 0;
	forn(i,n) for (int j=i+1; j<n; j++) {
		num x;
		forn(k,4) x.a[k] = data[i].a[k]^data[j].a[k];	
		
		/*double xx =0;
		double dd = 1;
		for (int k=0; k<4; k++) {
			xx += x.a[k]*dd;
			dd *= sz;
		}
		if (xx>1)	RES += floor(log10(xx));*/
		
	
		int l = 0, r = 38;
		while (l<r) {
			int mid = (l+r+1)>>1;
			num& y = a[mid];
			if (cmp(x,y)) r = mid-1; else l = mid;
		}
		RES += r;
		
		
/*		int res = 0;
		for (int i=3; i>=0; --i) {
			res = hbit[x.a[i]>>16];
			if (res) {
				res += (i<<5)+16;
				break;
			}
			res = hbit[x.a[i]&msk2];
			if (res) {
				res += (i<<5);
				break;
			}
		}
		int n = log10_2[res];		
		if (res>0 && cmp(x,a[n])) n = log10_2[res-1];		
		RES += n;*/
	}
	cout << RES*2;	
    return 0;      
}  