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

const int inf = 1000000000;

struct edge {
    int x, cup, flow, cost;
};
const int maxn = 202 + 10;
const int maxm = 4 * 100 * 101 + 10;
edge e[maxm];
int nexte[maxm];
int head[maxn];
int gsz = 0;

void add_edge(int x, int y, int c, int cost) {
    //cout << x << " " << y << " " << c << " " << cost << endl;
    edge e1 = {y, c, 0, cost};
    edge e2 = {x, 0, 0, -cost};
    nexte[gsz] = head[x];
    e[gsz] = e1;
    head[x] = gsz++;


    nexte[gsz] = head[y];
    e[gsz] = e2;
    head[y] = gsz++;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    forn(i, maxn) head[i] = -1;
    int n, m;
    cin >> n >> m;
    int s = 0, t = n + m + 1;
    vi A(n);
    vi C(m);
    forn(i, n) cin >> A[i];
    forn(i, m) cin >> C[i];
    forn(i, n) add_edge(s, i + 1, A[i], 0);
    forn(i, n) {
        forn(j, m) {
            int val;
            cin >> val;
            add_edge(i + 1, n + j + 1, 1, -val);
        }
    }
    forn(j, m) {
        add_edge(n + j + 1, t, C[j], 0);
        for (int add = 1; add + C[j] <= n; add++) {
            if (add > 500) break;
            add_edge(n + j + 1, t, 1, add * 2 - 1);
        }
    }
    //mincost
    n = n + m + 2;
    vi phi(n, inf);
    phi[s] = 0;

    forn(k, n) {
        forn(v, n) {
            if (phi[v] < inf)
                for (int i = head[v]; i >= 0; i = nexte[i]) {
                    if (e[i].flow < e[i].cup) {
                        phi[e[i].x] = min(phi[e[i].x], phi[v] + e[i].cost);
                    }
                }
        }
    }

    int total_price = 0, res = 0;
    int flow = 0;
    while (true) {
        priority_queue<pii, std::vector<pii>, std::greater<pii>> q;
        vi d(n, inf), p(n, -1);
        vector<bool> f(n);
        q.push({0, s});
        while (!q.empty()) {
            int dist = q.top().first;
            int v = q.top().second;
            q.pop();
            if (f[v]) continue;
            f[v] = true;
            d[v] = dist;
            if (v == t) break;
            for (int i = head[v]; i >= 0; i = nexte[i]) {
                int u = e[i].x;
                if (f[u]) continue;
                if (e[i].flow < e[i].cup) {
                    int nd = dist + e[i].cost + phi[v] - phi[u];
                    assert((e[i].cost + phi[v] - phi[u]) >= 0);
                    if (d[u] > nd) {
                        d[u] = nd;
                        p[u] = i;
                        q.push({nd, u});
                    }
                }
            }
        }
        forn(v, n) if (f[v]) phi[v] += d[v] - d[t];
        if (p[t] < 0) break;
        int flow_add = inf;
        int v = t;
        while (v != s) {
            flow_add = min(flow_add, e[p[v]].cup - e[p[v]].flow);
            v = e[p[v] ^ 1].x;
        }
        if (flow_add == 0) break;
        flow += flow_add;
        v = t;
        while (v != s) {
            e[p[v]].flow += flow_add;
            e[p[v] ^ 1].flow -= flow_add;
            total_price += e[p[v]].cost * flow_add;
            //cout << v << "<-";
            v = e[p[v] ^ 1].x;
        }
        if (total_price < res) res = total_price;
        // cout << s << endl;
    }

    //cout << flow << " " << total_price;
    cout << -res;


}
