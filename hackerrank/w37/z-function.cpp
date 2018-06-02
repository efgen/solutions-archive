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

int mod = 1000000000 + 7;
const int maxn = 64;

int s[maxn], pi[maxn];
ll P[maxn], R[maxn];
int n, k;
int res = 0;
int C[maxn][maxn];


void go(int p, int best, int used) {
    if (p == n) {
        res += (best * R[used]) % mod;
        if (res >= mod) res -= mod;
//        forn(i, n) cout << s[i] << " ";
//        cout << ": " << best << " " << R[used];
//        cout << endl;
    }
//    else if (p > 0 && pi[p - 1] + (n - p) <= best) {
//        res = (int) ((res + P[n - p] * best) % mod);
//    }
    else {
        int new_used = min(used + 1, k);
        forn(c, new_used) {
            s[p] = c;
            int j = pi[p - 1];
            while (j > 0 && c != s[j])
                j = pi[j - 1];
            if (c == s[j]) ++j;
            pi[p] = j;
            go(p + 1, max(best, j), c >= used ? new_used : used);
        }
    }
}


int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    C[0][0] = 1;
    for (int i = 1; i < maxn; i++) {
        C[i][0] = C[i][i] = 1;
        for (int j = 1; j < i; j++) {
            C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            if (C[i][j] >= mod) C[i][j] -= mod;
        }
    }
//    for (n = 2; n <= 11; n++) {
//        for (k = 1; k <= 11; k++) {
//            P[0] = 1;
//            forn(i, n) P[i + 1] = P[i] * k % mod;
//            res = 0;
//            go(0, 0);
//            cout << "d[" << n << "][" << k << "]=" << res << ";" << endl;
//        }
//
//    }

    cin >> n >> k;
    P[0] = 1;
    R[0] = 1;
    forn(i, n) P[i + 1] = P[i] * k % mod;
    forn(i, n) R[i + 1] = R[i] * (k - i) % mod;
    go(1, 0, 1);
    cout << res;

    return 0;
}
