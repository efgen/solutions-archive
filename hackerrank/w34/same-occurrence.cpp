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
const int maxn = 8008;

int slen(int x) {
    return x * (x + 1) / 2;
}

int progression(int a, int k) {
    return k * (2 * a + k - 1) / 2;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, q;
    cin >> n >> q;
    vi a(n);
    forn(i, n) cin >> a[i];
    unordered_map<int, int> ind;
    vi occurences[maxn];
    vi fallback(n);
    forn(i, n) {
        int x = a[i];
        if (!ind.count(x)) ind[x] = ind.size();
        a[i] = ind[x];
        occurences[a[i]].pb(i);
    }
    for (int t = 0; t < ind.size(); t++) {
        int ppos = -1;
        int res = 0;
        for (int x:occurences[t]) {
            res += slen(x - ppos - 1);
            ppos = x;
        }
        res += slen(n - ppos - 1);
        fallback[t] = res;
    }

    int N = ind.size();
    unordered_map<int, int> cache;
    forn(i, q) {
        int u, v;
        cin >> u >> v;
        u = ind.count(u) ? ind[u] : -1;
        v = ind.count(v) ? ind[v] : -1;
        int res = 0;
        if (u >= 0 && v >= 0) {
            if (u == v) {
                res = slen(n);
            } else {
                if (u > v) swap(u, v);
                int key = u * N + v;
                if (cache.count(key)) {
                    res = cache[key];
                } else {
                    unordered_map<int, int> sums;
                    auto iu = occurences[u].begin();
                    auto iv = occurences[v].begin();
                    int sum = 0;
                    forn(i, n) {
                        int x = 0;
                        if (iv != occurences[v].end() && i == *iv) {
                            x = 1;
                            iv++;
                        } else if (iu != occurences[u].end() && i == *iu) {
                            x = -1;
                            iu++;
                        } else {
//                            if (sum == 0) res++;
//                            if (sums.count(sum)) {
//                                res += sums[sum];
//                            }
//                            sums[sum]++;
//                            continue;
                            int np = n;
                            if (iv != occurences[v].end() && iu != occurences[u].end()) {
                                if (*iv < *iu) {
                                    np = *iv;
                                } else {
                                    np = *iu;
                                };
                            } else if (iv != occurences[v].end()) {
                                np = *iv;
                            } else if (iu != occurences[u].end()) {
                                np = *iu;
                            }
                            int cnt = np - i;
                            if (sum == 0) res += cnt;
                            int add = 0;
                            if (sums.count(sum)) {
                                add = sums[sum];
                            }
                            res += progression(add, cnt);
                            sums[sum] += cnt;
                            i = np - 1;
                            continue;
                        }
                        sum += x;
                        if (sum == 0) res++;
                        if (sums.count(sum)) {
                            res += sums[sum];
                        }
                        sums[sum]++;
                    }

                    cache[key] = res;
                }

            }

        } else {
            if (u < 0 && v < 0) res = slen(n);
            else if (u < 0) res = fallback[v]; else res = fallback[u];

        }
        cout << res << endl;
    }

    return 0;
}

