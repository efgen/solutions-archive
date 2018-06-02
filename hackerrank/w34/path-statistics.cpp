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
vi ans;

struct lca {
    int n, len;
    vi tin, tout;
    vi torder;
    vvi up;

    void init(const vvi &tree) {
        n = tree.size();
        len = 1;
        while ((1 << len) <= n) len++;
        up.assign(len, vi(n));

        tin.assign(n, 0);
        tout.assign(n, 0);
        torder.assign(2 * n, 0);

        function<void(int, int, int &)> dfs = [&](int u, int parent, int &t) {
            //cout << u << " ";
            tin[u] = t;
            torder[t++] = u;
            up[0][u] = parent;
            for (int i = 1; i < len; i++) {
                up[i][u] = up[i - 1][up[i - 1][u]];
            }

            for (int v : tree[u])
                if (v != parent) {
                    dfs(v, u, t);
                }

            tout[u] = t;
            torder[t++] = u;
            //cout << u << " ";
        };

        int timer = 0;
        int start = n / 2;
        dfs(start, start, timer);
        // cout << "dfs\n";
    }

    bool is_parent(int parent, int child) {
        return tin[parent] <= tin[child] && tout[child] <= tout[parent];
    }

    int query_lca(int a, int b) {
        if (is_parent(a, b))
            return a;
        if (is_parent(b, a))
            return b;
        for (int i = len - 1; i >= 0; i--)
            if (!is_parent(up[i][a], b))
                a = up[i][a];
        return up[0][a];
    }

};


vvi a;
vi c;
unordered_map<int, int> cnts;
vector<pii> freq;
lca L;
int blockSize;
vi visited;

struct query {
    int l, r, k, id, add = -1;

    bool operator<(const query &q) const {
        if (l / blockSize != q.l / blockSize) return l < q.l;
        return r > q.r;
    }
};

void mo_add(int x) {
    if (visited[x]) {
        cnts[c[x]]--;
    } else
        cnts[c[x]]++;
    visited[x] ^= 1;

}

void mo_remove(int x) {
    if (!visited[x]) {
        cnts[c[x]]++;
    } else
        cnts[c[x]]--;
    visited[x] ^= 1;
}

int mo_calc(const query &q) {
    if (q.add > 0) mo_add(q.add);
    int cnt = 0;
    for (auto kv:cnts) {
        freq[cnt].X = kv.Y;
        freq[cnt].Y = kv.X;
        //cout << kv.X << ": " << kv.Y << endl;
        cnt++;
    }
    //cout << "query end" << endl;
    if (q.add > 0) mo_remove(q.add);
    auto pos = freq.begin() + (cnt - q.k);
    nth_element(freq.begin(), pos, freq.begin() + cnt);
    return (*pos).Y;
}

void mo_routine(const vi &a, vector<query> qs) {
    int n = a.size();
    blockSize = (int) sqrt(n);
    sort(all(qs));

    int l = 0, r = -1;
    for (auto q:qs) {
        while (l > q.l) {
            mo_add(a[--l]);
        }
        while (r < q.r) {
            mo_add(a[++r]);
        }
        while (l < q.l) {
            mo_remove(a[l++]);
        }
        while (r > q.r) {
            mo_remove(a[r--]);
        }

        ans[q.id] = mo_calc(q);
    }
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, q;
    scanf("%d%d", &n, &q);
    freq.assign(n + 1, pii());
    c.assign(n, 0);
    a.assign(n, vi());
    ans.assign(q, 0);
    forn(i, n) scanf("%d", &c[i]);
    forn(i, n - 1) {
        int x, y;
        scanf("%d%d", &x, &y);
        x--;
        y--;
        a[x].pb(y);
        a[y].pb(x);
    }
    L.init(a);

    vector<query> qs(q);
    forn(i, q) {
        int u, v, k;
        scanf("%d%d%d", &u, &v, &k);
        u--;
        v--;
        if (L.tin[u] > L.tin[v]) swap(u, v);
        int p = L.query_lca(u, v);
        if (p == u) {
            qs[i].l = L.tin[u];
            qs[i].r = L.tin[v];
        } else {
            qs[i].l = L.tout[u];
            qs[i].r = L.tin[v];
            qs[i].add = p;
        }
        qs[i].k = k;
        qs[i].id = i;

        // cout << u << " " << v << " " << p << " " << qs[i].l << " " << qs[i].r << " " << qs[i].add << endl;
    }
    visited.assign(n, 0);
    mo_routine(L.torder, qs);

    forn(i, q) {
        printf("%d\n", ans[i]);
    }

    return 0;
}
