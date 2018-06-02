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

int n, m;
vvi a;
vi d, zc;

void update(int row, int add) {
    forn(i, m) {
        d[i] ^= a[row][i];
        if (a[row][i] == 1) {
            zc[i] += add;
        }
    }
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n >> m;
    int N = n, M = m;
    bool reversed = false;
    if (n > m) {
        swap(n, m);
        reversed = true;
    }
    a.assign(n, vi(m));
    forn(i, N) {
        forn(j, M) {
            int x;
            cin >> x;
            x = 1 << x;
            if (reversed) {
                a[j][i] = x;
            } else {
                a[i][j] = x;
            }
        }
    }
    int bestA = 1;
    int rx1 = 0, rx2 = 0, ry1 = 0, ry2 = 0;

    d.assign(m, 0);
    zc.assign(m, 0);

    vi firstPos(1024);

    for (int x1 = 0; x1 < n; x1++) {
        forn(i, m) d[i] = zc[i] = 0;
        for (int x2 = x1; x2 < n; x2++) {
            int w = x2 - x1 + 1;
            update(x2, +1);
            if (w * m <= bestA) continue;

            fill(all(firstPos), -1);
            vi zcs(m + 1);
            int val = 0;
            forn(t, m) {
                val ^= d[t];
                zcs[t + 1] = zc[t] + zcs[t];
                int start = t + 1;
                if (!val || !(val & (val - 1))) start = 0;
                else {
                    int prev = firstPos[val];
                    if (prev >= 0) start = prev + 1;
                }
                forn(dig, 10) {
                    int nv = val ^(1 << dig);
                    if (firstPos[nv] >= 0) start = min(start, firstPos[nv] + 1);
                }
                if (firstPos[val] < 0) firstPos[val] = t;
                int len = t - start + 1;
                int a = len * w;
                if (a <= bestA) continue;
                int zero = zcs[t + 1] - zcs[start];

                if (zero == a || zero == a - 1) continue;
                bestA = a;
                rx1 = x1;
                rx2 = x2;
                ry1 = start;
                ry2 = t;
            }
        }
    }

    if (reversed) {
        swap(rx1, ry1);
        swap(rx2, ry2);
    }
    cout << bestA << endl;
    cout << rx1 << " " << ry1 << " " << rx2 << " " << ry2;
    return 0;
}
