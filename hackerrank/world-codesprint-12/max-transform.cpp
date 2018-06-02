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
const int mod = 1000000000 + 7;

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int N;
    cin >> N;
    vi data(N, 0);
    int n = N * (N + 1) / 2;
    vi a(n, 0);
    vi L(n, 0);
    vi R(n, 0);
    forn(i, N) cin >> data[i];
    int start = 0, len = N;
    forn(i, N) a[i] = data[i];
    while (len > 1) {
        for (int j = 0; j < len - 1; j++) {
            a[start + len + j] = max(a[start + j], a[start + j + 1]);
        }
        start += len;
        len--;
    }
//    forn(i, n) cout << a[i] << endl;

    stack<int> st;
    forn(i, n) {
        while (!st.empty() && a[st.top()] < a[i]) {
            st.pop();
        }
        L[i] = st.empty() ? -1 : st.top();
        st.push(i);

    }
    while (!st.empty()) st.pop();
    for (int i = n - 1; i >= 0; --i) {
        while (!st.empty() && a[st.top()] <= a[i]) {
            st.pop();
        }
        R[i] = st.empty() ? n : st.top();
        st.push(i);
    }
//    forn(i, n) {
//        cout << i << " " << a[i] << " " << L[i] << " " << R[i] << endl;
//    }
    ll res = 0;
    forn(i, n) {
        res += (ll) a[i] * ((ll) (R[i] - i) * (i - L[i]) % mod) % mod;
    }
    cout << res % mod;
    return 0;
}
