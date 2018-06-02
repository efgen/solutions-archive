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

map<vi, int> mem;
int n = 3;

int G(vi p) {
	if (mem[p]) return mem[p];
	vi p2(n);
	forn(i, n) {
		p2[i] = p[i];
	}
	set<int> v;
	int min = 1000000;
	int gx = 0;
	forn(i, n) {
		if (p[i] < min) min = p[i];
		gx ^= p[i];
	}
	if (min == 0) {
		return mem[p] = gx;
	}
	for (int i = 0; i < n; i++) {
		for (int x = 0; x < p[i]; x++) {
			p2[i] = x;
			v.insert(G(p2));
		}
		p2[i] = p[i];

	}

	for (int k = 1; k <= min; k++) {
		forn(i, n) {
			p2[i] = p[i] - k;
		}
		v.insert(G(p2));
	}
	for (int i = 0; true; i++) {
		if (!v.count(i)) {
			mem[p] = i;
			return i;
		}
	}
}

int G2(vi a) {
	int res = 0;
	for (int x:a) {
		res ^= x;
	}
	return res;
}

#define maxn  1000000
int f[maxn];
int main() {
	int k = 1;
	for (int i=1; i<maxn; i++) {
		if (!f[i]) {
			f[i] = i+k;
			if (i+k<maxn) f[i+k] = i;
			k++;
		}
	}
	

	int q;
	cin >> q;
	while (q--) {
		cin >> n;
		vi p(n, 0);
		forn(i, n) cin >> p[i];
		int x = 0;
		forn(i, n) {
			x ^= p[i];

		}
		bool ok = x >0;
		if (n == 2) {
			ok = f[p[0]] != p[1];
		}
		if (ok) cout << "Sherlock"; else cout << "Watson";

		cout << endl;
	}





}
