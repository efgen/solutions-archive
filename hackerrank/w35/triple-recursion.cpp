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
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define sz(x) ((int)(x).size())
#define X first
#define Y second
template<class T> inline T sqr(T x) { return x * x; }
template<class T> inline T parse(const string&s){T x;stringstream ss(s);ss>>x;return x;}
// @formatter:on
const int inf = 1000000000;
vvi a;
int n, m, k;

int get(int i, int j) {
    if (a[i][j] != inf) return a[i][j];
    if (i == 0 && j == 0) return a[i][j] = m;
    if (i == j) return a[i][j] = get(i - 1, j - 1) + k;
    if (i > j) return a[i][j] = get(i - 1, j) - 1; else return a[i][j] = get(i, j - 1) - 1;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    cin >> n >> m >> k;
    a.assign(n, vi(n, inf));

    forn(i, n) {
        forn(j, n) {
            cout << get(i, j) << " ";
        }
        cout << endl;
    }

    return 0;
}


