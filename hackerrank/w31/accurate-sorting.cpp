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
		vi a(n);
		forn(i, n) cin >> a[i];
		for(int i=1; i<n; i++) if (a[i-1]-a[i]==1) {
			swap(a[i-1], a[i]);
		}
		bool ok = true;
		forn(i, n) ok &= a[i]==i;
		if (ok) cout << "Yes"; else cout << "No";
		cout << endl;
	}
	
}
