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


int cnts[100000 + 10];
set<int> invCnt[100000 + 10];


void add(int x) {
    cnts[x]++;
//    int val = cnts[x];
//    if (val) {
//        invCnt[val].erase(x);
//    }
//    invCnt[++cnts[x]].insert(x);
}

void remove(int x) {
    cnts[x]--;
//    int val = cnts[x];
//    invCnt[val].erase(x);
//    if (val == 1) {
//        cnts[x]--;
//    } else {
//        invCnt[--cnts[x]].insert(x);
//    }
}

int blockSize;

struct query {
    int l, r, x, id;

    bool operator<(const query &q) const {
        if (l / blockSize != q.l / blockSize) return l / blockSize < q.l / blockSize;
        return r < q.r;
    }
};

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int T;
    cin >> T;
    while (T--) {
        int n, g;
        cin >> n;
        vi a(n);
        blockSize = (int) sqrt(n);
        forn(i, n) cin >> a[i];
        cin >> g;
        vector<query> qs(g);
        vi ans(g);
        forn(i, g) {
            cin >> qs[i].l >> qs[i].r >> qs[i].x;
            // qs[i].r++;
            qs[i].id = i;
        }

        sort(all(qs));

        int l = 0, r = 0;
        for (auto q:qs) {
            while (l < q.l) {
                remove(a[l++]);
            }
            while (l > q.l) {
                add(a[--l]);
            }
            while (r <= q.r) {
                add(a[r++]);
            }
            while (r > q.r + 1) {
                remove(a[--r]);
            }
            int res = -1;
            forn(i, n) {
                if (cnts[i] == q.x) {
                    res = i;
                    break;
                }
            }
            ans[q.id] = res;
            //ans[q.id] = invCnt[q.x].empty() ? -1 : *(invCnt[q.x].begin());
        }

//        while (l < r) {
//            remove(a[l++]);
//        }

        forn(i, n) {
            cnts[i] = 0;
            invCnt[i + 1].clear();
        }

        forn(i, g) {
            cout << ans[i] << endl;
        }

    }


}
