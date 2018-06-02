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
int mod = 1000000000 + 7;

vi primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
bool is_prime[50];
vi a(10);
int cnt = 0;
vi prefix;

void gen(int n, int p) {
	if (p == 5) {
		prefix.push_back(n);
		return;
	}
	for (int x = 0; x < 10; x++) {
		a[p] = x;
		bool ok = true;
		if (p >= 2) {
			ok &= is_prime[a[p] + a[p - 1] + a[p - 2]];
		}
		if (p >= 3) {
			ok &= is_prime[a[p] + a[p - 1] + a[p - 2] + a[p - 3]];
		}
		if (p >= 4) {
			ok &= is_prime[a[p] + a[p - 1] + a[p - 2] + a[p - 3] + a[p - 4]];
		}
		if (ok) gen(n * 10 + x, p + 1);
	}
}


void dummy(int p) {
	if (p == 1) {
		forn(i, p) cout << a[i];
		cout << endl;
		cnt++;
		return;
	}
	for (int x = p ? 0 : 1; x < 10; x++) {
		a[p] = x;
		bool ok = true;
		if (p >= 2) {
			ok &= is_prime[a[p] + a[p - 1] + a[p - 2]];
		}
		if (p >= 3) {
			ok &= is_prime[a[p] + a[p - 1] + a[p - 2] + a[p - 3]];
		}
		if (p >= 4) {
			ok &= is_prime[a[p] + a[p - 1] + a[p - 2] + a[p - 3] + a[p - 4]];
		}
		if (ok) dummy(p + 1);
	}
}

int main() {
	for (int x:primes) is_prime[x] = true;
	gen(0, 0);
	cnt = prefix.size();
	vvi g(cnt, vi(0));
	forn(i, cnt) {
		int nx = prefix[i] % 10000;
		nx *= 10;
		for (int c = 0; c < 10; c++) {
			auto first = lower_bound(all(prefix), nx);
			if (first != end(prefix) && nx == *first) {
				g[i].pb(first - begin(prefix));
			}
			nx++;
		}
	}


	vi d(cnt);
	vi d2(cnt);
	int maxn = 400000;

	vi res(maxn + 1);
	maxn -= 4;
	forn(i, cnt) {
		if (prefix[i] >= 10000) d2[i] = 1;
	}
	for (int steps = 0; steps < maxn; steps++) {
		int r = 0;
		for (int i = 0; i < cnt; i++) {
			d[i] = d2[i];
			d2[i] = 0;
			r += d[i];
			if (r >= mod) r -= mod;
		}
		res[steps + 5] = r;
		for (int i = 0; i < cnt; i++)
			if (d[i])
				for (int x:g[i]) {
					d2[x] += d[i];
					if (d2[x] >= mod) d2[x] -= mod;
				}

	}
	res[1] = 9;
	res[2] = 90;
	res[3] = 303;
	res[4] = 280;
	int q;
	cin >> q;
	while (q--) {
		int x;
		cin >> x;
		cout << res[x] << endl;
	}


}

