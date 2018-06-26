// @formatter:off
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, int> node;
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
#define next notanigous
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
// @formatter:on
const int inf = 1000000000;
int n, m, S, T;

struct edge {
    int x, cup, flow, cost;
};

const int maxn = 2048;
const int maxm = 8 * 2048 + 10;
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

void reset() {
    forn(i, n) head[i] = -1;
    gsz = 0;
}

int min_cost_flow(int need) {

    vi phi(n, inf);
    phi[S] = 0;

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

    int total_price = 0;
    int flow = 0;
    while (true) {
        priority_queue<pii, std::vector<pii>, std::greater<pii>> q;
        vi d(n, inf), p(n, -1);
        vector<bool> f(n);
        q.push({0, S});
        while (!q.empty()) {
            int dist = q.top().first;
            int v = q.top().second;
            q.pop();
            if (f[v]) continue;
            f[v] = true;
            d[v] = dist;
            if (v == T) break;
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
        forn(v, n) if (f[v]) phi[v] += d[v] - d[T];
        if (p[T] < 0) break;
        int flow_add = inf;
        int v = T;
        while (v != S) {
            flow_add = min(flow_add, e[p[v]].cup - e[p[v]].flow);
            v = e[p[v] ^ 1].x;
        }

        if (flow + flow_add > need) flow_add = need - flow;
        if (flow_add == 0) break;
        flow += flow_add;
        v = T;
        while (v != S) {
            e[p[v]].flow += flow_add;
            e[p[v] ^ 1].flow -= flow_add;
            total_price += e[p[v]].cost * flow_add;
            v = e[p[v] ^ 1].x;
        }
    }

    return total_price;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int k, t;
    cin >> n >> m >> k >> t;
    S = 0, T = n - 1;
    vii raw_edges;
    forn(i, m) {
        int x, y;
        cin >> x >> y;
        raw_edges.pb({x, y});
    }
    int L = 1, R = k;
    while (L < R) {
        reset();
        int C = (L + R) >> 1;
        for (auto e:raw_edges) {
            add_edge(e.X, e.Y, C, 0);
            add_edge(e.Y, e.X, C, 0);
            add_edge(e.X, e.Y, k, 1);
            add_edge(e.Y, e.X, k, 1);
        }
        int flow_cost = min_cost_flow(k);
        if (flow_cost <= t) R = C; else L = C + 1;
    }

    cout << R - 1;

    return 0;
}
