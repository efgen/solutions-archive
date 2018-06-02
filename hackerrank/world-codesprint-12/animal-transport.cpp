// @formatter:off
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
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
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
// @formatter:on

struct max_seg_tree {
    vi a, lazy;
    vi t;

    void init(const vi &data) {
        int N = data.size();
        a.assign(N, 0);
        forn(i, N) a[i] = data[i];
        int n = 1;
        while (n <= N) {
            n <<= 1;
        }
        n <<= 1;
        t.assign(n, 0);
        lazy.assign(n, 0);
    }

    void update(int v) {
        t[v] = max(t[2 * v], t[2 * v + 1]);
    }

    void build(int v, int L, int R) {
        if (L == R) {
            t[v] = a[L];
        } else {
            int mid = (L + R) >> 1;
            build(2 * v, L, mid);
            build(2 * v + 1, mid + 1, R);
            update(v);
        }
    }

    void push(int v, int L, int R) {
        if (lazy[v] != 0) {
            t[v] += lazy[v];
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

    void set_val(int v, int L, int R, int pos, int val) {
        push(v, L, R);
        if (L == pos && R == pos) {
            t[v] = val;
        } else {
            int mid = (L + R) >> 1;
            if (pos <= mid) {
                set_val(2 * v, L, mid, pos, val);
                push(2 * v + 1, mid + 1, R);
            } else {
                set_val(2 * v + 1, mid + 1, R, pos, val);
                push(2 * v, L, mid);
            }
            update(v);
        }
    }

    int query_max(int v, int L, int R, int l, int r) {
        if (L > R || L > r || R < l) {
            return 0;
        }
        push(v, L, R);
        if (l <= L && r >= R) {
            return t[v];
        }
        int mid = (L + R) >> 1;
        auto r1 = query_max(2 * v, L, mid, l, r);
        auto r2 = query_max(2 * v + 1, mid + 1, R, l, r);
        return max(r1, r2);
    }
};

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int tests;
    cin >> tests;
    while (tests--) {
        int m, n;
        cin >> m >> n;
        vi color(n, 0);
        vi start(n, 0);
        vi fin(n, 0);
        vector<vi> beg[2];
        beg[0].assign(m + 1, vi());
        beg[1].assign(m + 1, vi());
        forn(i, n) {
            char c;
            cin >> c;
            if (c == 'E' || c == 'C') color[i] = 1;
        }
        forn(i, n) cin >> start[i];
        forn(i, n) cin >> fin[i];

        forn(i, n) {
            if (start[i] < fin[i]) {
                beg[color[i]][fin[i]].pb(start[i]);
            }
        }
        max_seg_tree tm[2];
        vi zeroes(m + 1, 0);
        tm[0].init(zeroes);
        tm[1].init(zeroes);

        vi dp(m + 1, 0);
        vi ans(n + 1, -1);
        int prev = 0;
        for (int i = 1; i <= m; i++) {

            forn(t, 2) {
                for (int x:beg[t][i]) {
//                    cnts[t][x]++;
                    tm[t].range_add(1, 0, m, 0, x, 1);
                }
            }

            dp[i] = max(tm[0].query_max(1, 0, m, 0, i), tm[1].query_max(1, 0, m, 0, i));
            tm[0].set_val(1, 0, m, i, dp[i]);
            tm[1].set_val(1, 0, m, i, dp[i]);

//            dp[i] = dp[i - 1];
//            int r0 = 0, r1 = 0;
//            for (int j = i - 1; j >= 0; --j) {
//                r0 += cnts[0][j];
//                r1 += cnts[1][j];
//                dp[i] = max(dp[i], dp[j] + max(r0, r1));
//            }



            while (dp[i] > prev) {
                prev++;
                ans[prev] = i;
            }
        }
        for (int i = 1; i <= n; i++) cout << ans[i] << " ";
        cout << endl;
    }

    return 0;
}
