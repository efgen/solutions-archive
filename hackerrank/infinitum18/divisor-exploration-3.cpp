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
#define forv(i,v) forn(i,sz(v))
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on

ll mod = 1000000000 + 7;
const int maxn = 3002;
int C[maxn][maxn];

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int maxp = 8000;
    vi p;
    vector<bool> f(maxp);
    for (int i = 2; i < maxp; i++)
        if (!f[i]) {
            p.push_back(i);
            for (int j = i * i; j < maxp; j += i) f[j] = true;
        }

    C[0][0] = 1;
    for (int n = 1; n < maxn; n++) {
        C[n][0] = 1;
        for (int k = 1; k <= n; k++) {
            C[n][k] = C[n - 1][k - 1] + C[n - 1][k];
            if (C[n][k] >= mod) C[n][k] -= mod;
        }
    }
    int q;
    cin >> q;
    while (q--) {
        int m, a, d;
        cin >> m >> a >> d;
        d -= 2;
        ll res = 1;
        forn(k, m) {
            int n = a + k + 1;
            ll sigm = 0;
            ll P = 1;
            if (d < 0) {
                sigm = powmod(p[k], n, mod);
            } else {
                for (int i = n; i >= 0; --i) {
                    sigm = (sigm + C[d + i][i] * P) % mod;
                    P = P * p[k] % mod;
                }
            }
            res = res * sigm % mod;
            // cout << p[k] << " " << n << " " << " " << d << " " << sigm << endl;

        }
        cout << res << endl;
    }

    return 0;
}
