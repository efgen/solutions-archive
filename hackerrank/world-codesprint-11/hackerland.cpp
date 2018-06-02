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

const int sze = 1563;
const int maxn = 50000;
unsigned int tc2[maxn][sze];
vi g[maxn], gt[maxn], gc[maxn];
bool f[maxn];
bool req[maxn];
vi order;
int comp[maxn];
int cc = 0;

void dfs1(int v) {
    f[v] = 1;
    for (int x:g[v])
        if (!f[x]) {
            dfs1(x);
        }
    order.pb(v);
}


void add(int x, int y) {
    g[x].pb(y);
    gt[y].pb(x);
}

void dfs2(int v) {
    f[v] = true;
    comp[v] = cc;
    for (int x:gt[v]) {
        if (!f[x]) dfs2(x);
    }
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int n, m;
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; i++) {
        int x, y;
        scanf("%d%d", &x, &y);
        x--;
        y--;
        add(x, y);
    }


    int q;
    cin >> q;
    vector<pii> queries;
    while (q--) {
        int c, x, y;
        scanf("%d%d%d", &c, &x, &y);
        if (c == 1) {
            x--;
            if (y == 0) add(x, n++); else add(n++, x);
        } else {
            x--;
            y--;
            queries.pb({x, y});
            req[x] = true;
        }
    }
    forn(i, n) if (!f[i]) dfs1(i);
    reverse(all(order));
    forn(i, n) f[i] = 0;
    for (int x:order) {
        if (!f[x]) {
            dfs2(x);
            cc++;
        }
    }
    set<ll> edges;
    forn(v, n) {
        ll ce = ((ll) comp[v]) << 32;
        for (int x:g[v]) {
            if (comp[v] != comp[x] && !edges.count(ce + comp[x])) {
                edges.insert(ce + comp[x]);
                gc[comp[v]].pb(comp[x]);
                //cout << comp[v] << " -> " << comp[x] << endl;
            }
        }
    }
    forn(i, cc) { tc2[i][i >> 5] |= (1u << (i & 31)); }
    for (int v = cc - 1; v >= 0; --v) {
        for (int x:gc[v]) {
            forn(j, sze) tc2[v][j] |= tc2[x][j];
        }
    }

    for (auto q:queries) {
        int x = comp[q.X];
        int y = comp[q.Y];
        if (tc2[x][y >> 5] & (1u << (y & 31))) printf("Yes\n"); else printf("No\n");
    }
}
