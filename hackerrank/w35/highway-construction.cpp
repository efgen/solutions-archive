// @formatter:off
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
#define forn(i,n) for(int i=0;i<(n);++i)
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define sz(x) ((int)(x).size())
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
// @formatter:on
const int mod = 1000000000 + 9;

const int maxn = 1024;
int C[maxn][maxn];
ll B[maxn];

ll powmod(ll a, ll p, ll m) {
    ll r = 1;
    while (p) {
        if (p & 1)r = r * a % m;
        p >>= 1;
        a = a * a % m;
    }
    return r;
}

map<int, int> inv_cache;

ll inv(int x) {
    if (inv_cache.count(x)) return inv_cache[x];
    return inv_cache[x] = powmod(x, mod - 2, mod);
}

ll dummy(ll N, int n) {
    ll res = 0;
    forn(i, N + 1) {
        res += powmod(i, n, mod);
        res %= mod;

    }
    return res;
}

map<pair<int, int>, ll> cache;

ll get(int N, int n) {
    if (n == 0) return N;
    pair<int, int> key = {N, n};
    if (cache.count(key)) return cache[key];
    ll res = 0;
    for (int p = 0; p < n; p++) {
        res = (res + C[n + 1][p] * get(N, p)) % mod;
    }
    res = (powmod(N + 1, n + 1, mod) - 1 + mod - res + mod) % mod;

    return cache[key] = (res * inv(n + 1) % mod);
}


ll coefs[maxn][maxn];

void calc_coef(int n) {
    if (n == 0) return;
    for (int j = 1; j <= n + 1; j++) {
        coefs[n][j] = C[n + 1][j];
    }
    for (int p = 0; p < n; p++) {
        for (int j = 0; j <= n; j++) {
            coefs[n][j] = (mod + coefs[n][j] - (C[n + 1][p] * coefs[p][j] % mod)) % mod;
        }
    }
    ll d = inv(n + 1);
    for (int j = 1; j <= n + 1; j++) {
        coefs[n][j] = coefs[n][j] * d % mod;
    }
}

ll calc_fast(int N, int n) {
    ll res = 0;
    forn(k, n + 1) {
        res = (res + (C[n + 1][k] * B[k] % mod) * powmod(N + 1, n + 1 - k, mod)) % mod;
    }
    res = (res * inv(n + 1)) % mod;
    return res;
}


int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    C[0][0] = 1;
    for (int i = 1; i < maxn; i++) {
        C[i][0] = 1;
        for (int j = 1; j <= i; j++) {
            C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % mod;
        }
    }
    B[0] = 1;
    for (int n = 1; n < maxn - 1; n++) {
        ll res = 0;
        for (int k = 1; k <= n; k++) {
            res = (res + C[n + 1][k + 1] * B[n - k]) % mod;
        }
        res = (res * inv(n + 1)) % mod;
        res = (mod - res) % mod;
        B[n] = (int) res;
//        cout << n << " " << B[n] * 1L % mod << endl;
    }


//    for (int n = 1; n < maxn; n++) calc_coef(n);

    int q;
    cin >> q;
    while (q--) {
        ll n;
        int k;
        cin >> n >> k;
        n--;
        ll res = 0;
        if (n > 1) {
            if (n >= mod) {
                res += calc_fast(n % mod, k);
//                res += get(mod - 1, k) * (n / mod) % mod;
                res %= mod;
            } else {
                res = calc_fast(n, k);
            }

            res = (res - 1 + mod) % mod;
        }
        cout << res << endl;

    }

    return 0;
}


