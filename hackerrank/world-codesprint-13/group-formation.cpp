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

vi g, gs, g1, g2, g3;

int find(int x) {
    if (x == g[x]) return x; else return g[x] = find(g[x]);
}


int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int n, m, minSize, maxSize, g1Max, g2Max, g3Max;
    cin >> n >> m >> minSize >> maxSize >> g1Max >> g2Max >> g3Max;
    g.assign(n, 0);
    gs.assign(n, 0);
    g1.assign(n, 0);
    g2.assign(n, 0);
    g3.assign(n, 0);

    vector<string> name(n);
    map<string, int> names;
    forn(i, n) {
        string s;
        int grade;
        cin >> s >> grade;
        names[s] = i;
        name[i] = s;
        if (grade == 1) g1[i]++;
        if (grade == 2) g2[i]++;
        if (grade == 3) g3[i]++;
        gs[i] = 1;
        g[i] = i;
    }


    while (m--) {
        string na, nb;
        cin >> na >> nb;
        int a = names[na];
        int b = names[nb];
        a = find(a);
        b = find(b);
        if (a == b) continue;
        if (gs[a] + gs[b] > maxSize) continue;
        if (g1[a] + g1[b] > g1Max) continue;
        if (g2[a] + g2[b] > g2Max) continue;
        if (g3[a] + g3[b] > g3Max) continue;
        if (gs[b] > gs[a]) swap(a, b);
        g[b] = a;
        gs[a] += gs[b];
        g1[a] += g1[b];
        g2[a] += g2[b];
        g3[a] += g3[b];
    }
    int bestSize = 1;
    forn(i, n) if (gs[i] > bestSize) bestSize = gs[i];
    if (bestSize < minSize) cout << "no groups";
    else {
        set<string> res;
        forn(i, n) if (gs[find(i)] == bestSize) res.insert(name[i]);
        for (string s: res) cout << s << endl;
    }

    return 0;
}