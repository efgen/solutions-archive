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

#define forn(i, n) for (int i = 0; i < (int)(n); i++)
#define forv(i, v) forn(i, v.size())
#define all(v) v.begin(), v.end()
#define mp make_pair
#define pb push_back
#define maxn 100001
#define maxm 400001


int curComp[100001];
bool marked[maxn];
bool f[maxn * 10];
int sz = 0;
int go[1 << 10][10];


int h[maxn];
int e[maxm], nxt[maxm], w[maxm];
int cnt = 0;

ll cnts[1<<10];

void add(int x, int y, int v) {
    e[++cnt] = y;
    w[cnt] = v;
    nxt[cnt] = h[x];
    h[x] = cnt;
}


void dfs(int v) {
    f[v] = true;
    int d = v % 10;
    v /= 10;
    if (!marked[v]) {
        curComp[sz++] = v;
        marked[v] = true;
    }

    for (int i = h[v]; i; i = nxt[i]) {
        int x = e[i];
        int t = w[i] + d;
        if (t >= 10) t -= 10;
        x = 10 * x + t;
        if (!f[x]) {
            dfs(x);
        }
    }
}

void calcGo() {
    forn(msk, 1 << 10) {
        forn(k, 10) {
            int res = 0;
            forn(i, 10) if (msk & (1 << i)) res |= 1 << ((i + k) % 10);
            go[msk][k] = res;
        }
    }
}

int main() {
    calcGo();
    int n, m;
    scanf("%d%d", &n, &m);

    forn(i, m) {
        int x, y, c;
        scanf("%d%d%d", &x, &y, &c);
        x--;
        y--;
        c %= 10;
        add(x, y, c);
        add(y, x, (10 - c) % 10);
    }

    vl res(10);
    forn(s, n) {
        if (!marked[s]) {
            sz = 0;
            dfs(s * 10);
            if (sz == 1) continue;
            forn(i, 1<<10) cnts[i] = 0;
            forn(msk, 1 << 10) {
                forn(ii, sz) {
                    int i = 10*curComp[ii];
                    bool ok = true;
                    forn(j, 10) {
                        if (msk & (1 << j)) {
                            if (!f[i + j]) {
                                ok = false;
                                break;
                            }
                        }
                    }
                    if (ok) cnts[msk]++;
                }
            }

            for (int msk = 1; msk < (1 << 10); msk++) {
                int sign = __builtin_popcount(msk) & 1 ? 1 : -1;
                forn(k, 10) {
                    int t2 = go[msk][k];
                    res[k] += (cnts[msk] * cnts[t2] - cnts[msk | t2]) * sign;
                }
            }
        }
    }

    forn(i, 10) {
        cout << res[i] << endl;
    }
}
