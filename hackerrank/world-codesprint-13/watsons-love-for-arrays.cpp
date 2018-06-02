// @formatter:off
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<pii> vii;
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


vl a;
ll mod, req;

ll pow(ll x, ll n) {
    ll a = 1, b = x;
    while (n > 0) {
        if (n & 1) a = a * b % mod;
        b = b * b % mod;
        n >>= 1;
    }
    return a;
}

ll inv(ll a) {
    return pow(a, mod - 2);
}

ll solve(int l, int r) {
    int mid = (l + r) >> 1;
    ll res = 0;
    if (r - l > 1) {
        ll t = 1;
        map<ll, int> cnts;
        for (int i = mid; i < r; i++) {
            t = t * a[i] % mod;
            cnts[t]++;
        }
        t = 1;
        for (int i = mid - 1; i >= l; --i) {
            t = t * a[i] % mod;
            if (t == 0) {
                if (req != 0) break;
                res += (r - mid);
            } else {
                ll x = req * inv(t) % mod;
                res += cnts[x];
            }
        }
        res += solve(l, mid) + solve(mid, r);
    } else {
        if (a[l] % mod == req) res++;
    }

    return res;

}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n >> mod >> req;
        a.assign(n, 0);
        forn(i, n) cin >> a[i];
        cout << solve(0, n) << endl;

    }
    return 0;
}