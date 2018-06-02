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
#define sz(x) x.size()
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
int gcd(int a,int b){return a?gcd(b%a,a):b;}
ll gcd(ll a,ll b){return a?gcd(b%a,a):b;}
ll powmod(ll a,ll p,ll m){ll r=1;while(p){if(p&1)r=r*a%m;p>>=1;a=a*a%m;}return r;}
// @formatter:on

ll sum(ll a, ll b) {
    ll res = 0;
    while (a <= b) {
        res += a * a;
        a++;
    }
    return res;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif


    int n, m, q;
    scanf("%d%d%d", &n, &m, &q);
    vl sums(m + 1);
    for (ll x = 1; x <= m; x++) sums[x] = sums[x - 1] + x * x;

    int log = 1;
    while ((1 << log) <= m) log++;
    ll max_sum = sum(1, m);
    vector<vector<bool>> a(m + 1, vector<bool>(n));
    forn(i, n) {
        int cnt;
        scanf("%d", &cnt);
        while (cnt--) {
            int x;
            scanf("%d", &x);
            a[x][i] = true;
        }
    }

    map<pii, ll> cache;
    forn(qq, q) {
        ll res = 0;
        int l, r;
        scanf("%d%d", &l, &r);
        l--;
        int len = r - l;
        if (len >= log) res = max_sum;
        else {
            res = cache[{l, r}];
            if (!res) {
                res = max_sum;
                int msz = 1 << len;

                map<int, ll> w;
                for (int x = m; x > 0; x--) {
                    int req = 0;
                    for (int i = 0; i < len; i++) {
                        if (a[x][l + i]) req |= 1 << i;
                    }
                    w[req] += sqr(x);

//                    cout << x << ": " << req << endl;

                }
                if (w.size() == msz) {
                    for (int msk = 0; msk < msz; msk++) {
                        if (w[msk] < res) res = w[msk];
                    }
                } else res = 0;


//                for (int msk = 0; msk < msz; msk++) {
//                    ll cur = 0;
//                    for (int x = m; x > 0; x--) {
//                        bool ok = true;
//                        for (int i = 0; i < len; i++) {
//                            if (((msk >> i) & 1) ^ a[x][l + i]) {
//                                ok = false;
//                                break;
//                            }
//                        }
//                        if (ok) cur += sqr((ll) x);
//                        if (cur > res) break;
//                    }
//                    if (cur < res) res = cur;
//                }

                res = max_sum - res;
                cache[{l, r}] = res;
            }
        }
        cout << res << endl;
    }

    return 0;
}
