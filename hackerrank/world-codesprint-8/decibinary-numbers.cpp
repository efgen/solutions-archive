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

ll mem[285113 * 19];

ll f(int n, int k) {
	if (n < 0) return 0;
	if (n == 0) return 1;
	if (n > 9 * ((1 << k) - 1)) return 0;
	if (k == 1) {
		if (n < 10) return 1; else return 0;
	}
	int key = n * 19 + k - 1;
	if (mem[key]) return mem[key];
	ll res = 0;
	k--;
	int b = 1 << k;
	for (int c = 0; c < 10; c++, n -= b) {
		res += f(n, k);

	}
	mem[key] = res;
	return res;
}

vi cif(20);

void gen(int n, ll ord, int k) {
	if (k < 0) return;
	int b = 1 << (k - 1);
	for (int c = 0; c < 10; c++) {
		ll t = f(n - b * c, k - 1);
		if (ord > t) {
			ord -= t;
		} else {
			cif[k - 1] = c;
			gen(n - b * c, ord, k - 1);
			return;
		}
	}
}


void printAnsw(int x, ll k) {
	int c = 20;
	cif.assign(c, 0);
	gen(x, k, c);
	c--;
	while (c) {
		if (cif[c]) break;
		c--;
	}
	for (int i = c; i >= 0; --i) cout << cif[i];
	cout << endl;

}

int main() {

	int x = 0;
	ll old = 0;
	vector<ll> cnts;
	int digits = 0;
	while (true) {
		ll cnt = f(x, digits + 1);
		if (x == (1 << digits)) {
			digits++;
		}
		old += cnt;
		cnts.pb(old);
		if (old > 10000000000000000) break;
		x++;
	}

	

	int q = 0;
	cin >> q;
	while (q--) {
		ll x;
		cin >> x;
		auto pos = lower_bound(all(cnts), x);
		//cout << pos-begin(cnts);
		//cout << " " << *pos << endl;
		if (pos != begin(cnts)) {
			x -= *(pos - 1);
		}
		printAnsw(pos - begin(cnts), x);

	}


}


