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
const int inf = 1 << 30;
int n, m, maxStripe;
vector<vi> a, b;
const int maxn = 382;
int pre[maxn][maxn][maxn];

// pre[i][L][R] - minimum subaray sum from a[i][L]..a[i][R] with length at most k
void precalc(int K) {
    vi sum(m + 2);

    for (int i = 1; i <= n; i++) {
        for (int L = 1; L <= m; L++) {
            sum[L] = sum[L - 1] - a[i][L];
        }
        for (int L = 1; L <= m; L++) {
            deque<int> dq;
            dq.push_back(L - 1);
            int best = -inf;
            for (int R = L; R <= m; R++) {
                if (!dq.empty() && R - dq.front() > K) dq.pop_front();
                while (!dq.empty() && sum[dq.back()] >= sum[R]) dq.pop_back();
                dq.push_back(R);
                if (R > dq.front()) best = max(best, sum[R] - sum[dq.front()]);
                best = max(best, sum[R] - sum[R - 1]);
                pre[i][L][R] = -best;
            }
        }
    }
}

int get_max() {
    vi sum_u(n + 2);
    vi sum_d(n + 2);
    vector<vi> s;
    s.assign(n + 1, vi(m + 1, 0));

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            s[i][j] = s[i][j - 1] + a[i][j];
        }
    }

    int res = -inf;
    for (int l = 1; l <= m; l++) {
        for (int r = l; r <= m; r++) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                int v = s[i][r] - s[i][l - 1];
                sum += v;
                if (sum < 0) sum = 0;
                sum_u[i] = sum;
            }

            sum = 0;
            for (int i = n; i > 0; --i) {
                int v = s[i][r] - s[i][l - 1];
                sum += v;
                if (sum < 0) sum = 0;
                sum_d[i] = sum;
            }

            for (int i = 1; i <= n; i++) {
                int val = sum_u[i - 1] + sum_d[i + 1];
                int v = (s[i][r] - s[i][l - 1]);
                if (r - l + 1 == m) v -= pre[i][l][r]; else v -= min(pre[i][l][r], 0);
                if (val + v > res) res = val + v;
            }
        }
    }

    return res;
}

void transp() {
    b.assign(m + 1, vi(n + 1, 0));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            b[j][i] = a[i][j];
        }
    }
    swap(n, m);
    swap(a, b);
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n >> m >> maxStripe;
    a.assign(n + 1, vi(m + 1, 0));
    vi mem(max(n, m) + 2);
    forn(i, n) {
        forn(j, m) {
            cin >> a[i + 1][j + 1];
        }
    }

    precalc(maxStripe);
    int res = get_max();
    transp();
    precalc(maxStripe);
    res = max(res, get_max());
    cout << res;
    return 0;
}
