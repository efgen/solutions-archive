#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<string> vs;
typedef vector<vector<int> > vvi;
typedef vector<ll> vl;
typedef vector<vector<ll> > vvl;

#define forn(i, n) for (int i = 0; i < (int)(n); i++)
#define forv(i, v) forn(i, v.size())
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back



int main() {
	int q;
	cin >> q;
	while(q--) {
		int n;
		cin >> n;
		int res = 0;		
		vi a(n+2);
		int p = 0;
		a[p++] = 1;		
		forn(i, n) {
			cin >> a[p];
			if (p>=2 && !a[p] && a[p-1] && !a[p-2]) {
				a[p-1] = 0;
				p--;
				res++;
			}
			p++;
		}
		a[p++] = 1;
		int zc = 0;
		forn(i, p) {
			if (a[i]) {
				res += max(0, zc-2);
				zc = 0;
			} else {
				zc++;
			}            
		}      
		if (res&1) cout << "Alice"; else cout << "Bob";
        cout << endl;
		
	}

}
