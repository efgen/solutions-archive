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
const int mod = 1000000000 + 7;
int maxn = 10000000;
vector<vi> a;
vi c;
vector<bool> f;
int res = 0;
vi fib(maxn);

vi in, out;
vl dist;
int n;

tuple<ll, ll> logF(ll n) {
    if (n < maxn) return {fib[n], fib[n + 1]};
    ll a, b, c, d;
    tie(a, b) = logF(n >> 1);
    c = a * (b * 2 - a + mod);
    d = a * a + b * b;
    c %= mod;
    d %= mod;
    if (n & 1) {
        c += d;
        if (c >= mod) c -= mod;
        return {d, c};
    } else {
        return {c, d};
    }
}

tuple<ll, ll> get_fib(ll n) {
    if (n < 0) {
        auto fib = logF(-n);
        ll f0 = get<0>(fib);
        ll f1 = get<1>(fib);
        if (n & 1) f1 *= -1; else f0 *= -1;
        if (f0 < 0) f0 += mod;
        if (f1 < 0) f1 += mod;
        f1 = f0 + f1;
        if (f1 >= mod) f1 -= mod;
        return {f0, f1};
    }
    return logF(n);
};

struct fib_seg_tree {
    vl a, lazy;
    vi c1, c2;

    void init(const vl &data) {
        int N = data.size();
        a.assign(N, 0);
        forn(i, N) a[i] = data[i];
        int n = 1;
        while (n <= N) {
            n <<= 1;
        }
        n <<= 1;
        c1.assign(n, 0);
        c2.assign(n, 0);
        lazy.assign(n, 0);
    }

    void update(int v) {
        c1[v] = c1[2 * v] + c1[2 * v + 1];
        if (c1[v] >= mod) c1[v] -= mod;
        c2[v] = c2[2 * v] + c2[2 * v + 1];
        if (c2[v] >= mod) c2[v] -= mod;
    }

    void build(int v, int L, int R) {
        if (L == R) {
            auto fib = get_fib(a[L]);
            c1[v] = get<0>(fib);
            c2[v] = get<1>(fib);
        } else {
            int mid = (L + R) >> 1;
            build(2 * v, L, mid);
            build(2 * v + 1, mid + 1, R);
            update(v);
        }
    }

    void push(int v, int L, int R) {
        if (lazy[v] != 0) {
            auto fib = get_fib(lazy[v]);
            ll f0 = get<0>(fib);
            ll f1 = get<1>(fib);
            ll c1n = (f1 - f0 + mod) * c1[v] + f0 * c2[v];
            ll c2n = f0 * c1[v] + f1 * c2[v];
            c1[v] = (int) (c1n % mod);
            c2[v] = (int) (c2n % mod);
            if (L != R) {
                lazy[2 * v] += lazy[v];
                lazy[2 * v + 1] += lazy[v];
            }
            lazy[v] = 0;
        }
    }

    void range_add(int v, int L, int R, int l, int r, int add) {
        push(v, L, R);
        if (L > R || L > r || R < l) {
            return;
        }
        if (l <= L && r >= R) {
            lazy[v] += add;
            push(v, L, R);
        } else {
            int mid = (L + R) >> 1;
            range_add(2 * v, L, mid, l, r, add);
            range_add(2 * v + 1, mid + 1, R, l, r, add);
            update(v);
        }
    }

    tuple<ll, ll> query_sum(int v, int L, int R, int l, int r) {
        if (L > R || L > r || R < l) {
            return {0, 0};
        }
        push(v, L, R);
        if (l <= L && r >= R) {
            return {c1[v], c2[v]};
        }
        int mid = (L + R) >> 1;
        auto r1 = query_sum(2 * v, L, mid, l, r);
        auto r2 = query_sum(2 * v + 1, mid + 1, R, l, r);
        return {(get<0>(r1) + get<0>(r2)) % mod, (get<1>(r1) + get<1>(r2)) % mod};
    }
};


void dfs(int v, ll d) {
    d += c[v];
    res += get<1>(logF(d));
    if (res >= mod) res -= mod;
    f[v] = true;
    for (int x:a[v])
        if (!f[x]) dfs(x, d);
}

void dfs1(int v, ll w, int &time) {
    w += c[v];
    f[v] = true;
    in[v] = time;
    dist[time] = w;
    time++;
    for (int x:a[v])
        if (!f[x]) dfs1(x, w, time);
    out[v] = time;
}

fib_seg_tree F;

void update_all(int w) {
    F.range_add(1, 0, n - 1, 0, n - 1, w);
}

void update(int l, int r, int w) {
    F.range_add(1, 0, n - 1, l, r - 1, w);
}

ll sum_all() {
    return get<1>(F.query_sum(1, 0, n - 1, 0, n - 1));
}

void dfs2(int v, int p) {
    res += sum_all();
    res %= mod;
    for (int x:a[v])
        if (x != p) {
            update_all(c[x]);
            update(in[x], out[x], -c[v] - c[x]);
            dfs2(x, v);
            update(in[x], out[x], +c[v] + c[x]);
            update_all(-c[x]);
        }
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i < maxn; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
        if (fib[i] >= mod) fib[i] -= mod;
    }
    maxn--;

    scanf("%d", &n);
    a.assign(n, vi());
    c.assign(n, 0);
    forn(i, n - 1) {
        int x, y;
        scanf("%d%d", &x, &y);
        x--;
        y--;
        a[x].pb(y);
        a[y].pb(x);
    }
    forn(i, n) scanf("%d", &c[i]);

    res = 0;
    f.assign(n, false);
    in.assign(n, 0);
    out.assign(n, 0);

    dist.assign(n, 0);
    int counter = 0;
    dfs1(0, 0, counter);
    F.init(dist);
    F.build(1, 0, n - 1);
    dfs2(0, -1);
    cout << res << endl;


    return 0;
}

