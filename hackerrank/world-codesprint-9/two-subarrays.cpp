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
#define inf 1000000000
#define maxn 100001
#define range 10

int a[maxn], s[maxn];
int d[range * 2 + 1];

int main() {
    int n;
    cin >> n;
    forn(i, n) cin >> a[i + 1];
    forn(i, n) {
        s[i + 1] = s[i] + a[i + 1];
    }
    int m = 2 * range + 1;

    int bestG = 0;
    int bestLen = 1;
    int bestCnt = n;

    for (int st = 1; st < n; st++) {
        forn(i, m) d[i] = -inf;
        int maxd = 0;
        for (int i = st; i <= n; i++) {
            int v = a[i] + range;
            d[v] = max(d[v], a[i]);
            forn(j, a[i] + range) {
                if (d[v] < d[j] + a[i]) {
                    d[v] = d[j] + a[i];
                }
            }
            maxd = max(maxd, d[v]);
            int F = s[i] - s[st - 1] - maxd;
            int len = i - st + 1;
            if (F > bestG) {
                bestG = F;
                bestLen = len;
                bestCnt = 1;
            } else if (F == bestG) {
                if (len < bestLen) {
                    bestLen = len;
                    bestCnt = 1;
                } else if (len == bestLen) {
                    bestCnt++;
                }
            }
        }
    }

    cout << bestG << " " << bestCnt;
}
