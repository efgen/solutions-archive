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

int n;
string s;
const int maxn = 4600000;
int go[maxn][26];
int last[300010];
int last_p[300010];
int cnt = 0;

void add(int l, int r) {
    int p = 0;
    int start = l;
    if (last[l] > 0) {
        start = last[l] + 1;
        p = last_p[l];
    }
    for (int i = start; i <= r; i++) {
        char c = s[i];
        if (!go[p][c]) p = go[p][c] = ++cnt; else p = go[p][c];
    }
    last[l] = r;
    last_p[l] = p;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> s;
    forn(i, n) s[i] -= 'a';
    vector<vi> p(2, vector<int>(n, 0));
    for (int z = 0, l = 0, r = 0; z < 2; z++, l = 0, r = 0)
        for (int i = 0; i < n; i++) {
            if (i < r) p[z][i] = min(r - i + !z, p[z][l + r - i + !z]);
            int L = i - p[z][i], R = i + p[z][i] - !z;
            while (L - 1 >= 0 && R + 1 < n && s[L - 1] == s[R + 1]) p[z][i]++, L--, R++;
            if (R > r) l = L, r = R;
        }

    int c1 = 0, c0 = 0;
    forn(i, n) {
        while (c1 <= i && c1 + p[1][c1] < i) c1++;
        while (c0 <= i && c0 + p[0][c0] - 1 < i) c0++;
        int from = i + 1;
        if (c1 <= i) from = min(from, 2 * c1 - i);
        if (c0 <= i) from = min(from, 2 * c0 - i - 1);
        if (from <= i) add(from, i);
        cout << cnt << endl;
    }
}
