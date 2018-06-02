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
const int mod = 1000000007;

int gen(int k, int m, int l, int g) {
	if (k == 0) {
		return g != 0 ? 1 : 0;
	}
	int res = 0;
	for (int x = l + 1; x < m; x++)
		res += gen(k - 1, m, x, g ^ x);
	return res;
}

ll mpow(ll x, int n) {
	ll a = 1, b = x;
	while (n) {
		if (n & 1) {
			a = a * b % mod;
		}
		b = b * b % mod;
		n >>= 1;
	}
	return a;
}

ll inv(ll x) {
	return mpow(x, mod - 2);
}

ll A(ll n, int k) {
	if (k > n) return 0;
	ll res = 1;
	for (int i = 0; i < k; i++) {
		res *= n - i;
		res %= mod;
	}
	return res;
}

ll G(int n, int k) {
	if (k > n) return 0;
	ll res = 1;
	for (int i = 0; i < k; i++) {
		res *= mpow(2, n - i) - 1;
		res %= mod;

		ll t = mpow(2, i + 1);
		if (t == 0) t = mod - 1; else t--;
		res *= inv(t);
		res %= mod;
	}
	res = (res + mod) % mod;
	return res;
}

ll fac(int n) {
	ll res = 1;
	for (int i = 2; i <= n; i++)
		res = res * i % mod;
	return res;
}

ll bad(int n, int k) {
	ll res = G(n, k - 1);
	ll mul = 1;
	if (k == 4) mul = 7;
	if (k == 5) mul = 168;
	res *= fac(k);
	res %= mod;
	res *= mul;
	return res % mod;
}


int main() {
	int k, m;
	cin >> k >> m;

	ll M = mpow(2, m);
	M = (M + mod - 1) % mod;

	if (k < 3) {
		cout << A(M, k);
	} else if (k < 6) {
		ll res = A(M, k);


		res -= bad(m, k);
		res %= mod;
		res = (res + mod) % mod;
		cout << res;


//		ll res2 = gen(k, 1 << m, 0, 0);
//		for (int i = 1; i <= k; i++)
//			res2 = res2 * i % mod;
//		cout << endl << res2;

	} else {
		if (m < 30) {
			if (k >= (1 << m)) {
				cout << 0;
			} else {
				ll res = gen(k, 1 << m, 0, 0);
				for (int i = 1; i <= k; i++)
					res = res * i % mod;
				cout << res;
			}
		} else {
			return 123;
		}
	}

}

