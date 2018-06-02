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

int field[151][1500 * 151];
int best_field[151][1500 * 151];
ll bH = 151, bW = 1500 * 151;
int n;
vector<vector<pii>> f;
vi wx, wy;

void tryit(vi &ord, int H) {
    int n = f.size();
    int shift = 0;
    forn(t, n) {
        int w = wx[ord[t]];
        int wyt = wy[ord[t]];

        for (int pos = max(0, shift - w); pos <= shift; pos++) {
            bool ok = true;
            for (int pos2 = 0; pos2 <= H - wyt; pos2++) {
                ok = true;
                for (auto p:f[ord[t]]) {
                    if (field[p.Y - 1 + pos2][p.X + pos - 1]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    for (auto p:f[ord[t]]) {
                        field[p.Y - 1 + pos2][p.X + pos - 1] = ord[t] + 1;
                    }
                    shift = pos + w;
                    if (shift >= bW) return;
                    break;
                }
            }
            if (ok) break;
        }
    }
    bH = H;
    bW = shift;

    forn(i, bH) forn(j, bW) best_field[i][j] = field[i][j];
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    clock_t t1, t2;
    t1 = clock() + 1900000;
    cin >> n;

    int H = 0;
    forn(t, n) {
        int s;
        cin >> s;
        vector<pii> fig(s);
        int maxX = 0, maxY = 0;
        forn(i, s) {
            cin >> fig[i].Y >> fig[i].X;
            if (fig[i].X > maxX) maxX = fig[i].X;
            if (fig[i].Y > maxY) maxY = fig[i].Y;
        }
        if (maxY > H) H = maxY;
        wx.pb(maxX);
        wy.pb(maxY);
        f.pb(fig);
    }

    vi ord(n);
    forn(i, n) ord[i] = i;


    while (true) {
        if (clock()>t1) break;
        random_shuffle(all(ord));
        tryit(ord, H);
        memset(field, 0, sizeof(field[0][0]) * 151 * 151 * 1500);
    }
    cout << bH << " " << bW << endl;
    forn(i, bH) {
        forn(j, bW) {
            cout << ((j) ? " " : "") << best_field[i][j];
        }
        cout << endl;
    }

}
