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

const int maxn = 1000000 + 10;
vi primes;
bool f[maxn];

ll factorize_solve(ll n) {
    ll res = 1;
    for (int x:primes) {
        while (n % x == 0) {
            n /= x;
            res = x * res + 1;
        }
        if (n == 1) break;
    }
    if (n > 1) res = n * res + 1;
    return res;
}


int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    for (int i = 2; i < maxn; i++)
        if (!f[i]) {
            for (int j = i + i; j < maxn; j += i)
                f[j] = true;
            primes.pb(i);
        }

    int t;
    cin >> t;
    ll res = 0;
    while (t--) {
        ll x;
        cin >> x;

        res += factorize_solve(x);
    }
    cout << res;


    return 0;
}
