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

int dx[] = {1, 1, 1, 0, 0, -1, -1, -1};
int dy[] = {1, 0, -1, 1, -1, 1, 0, -1};

int main() {
    int n, k, rq, cq;
    cin >> n >> k >> rq >> cq;
    rq--;
    cq--;
    set<pii> t;
    forn(i, k) {
        int r, c;
        cin >> r >> c;
        t.insert({r - 1, c - 1});
    }
    int res = 0;
    forn(d, 8) {
        int r = rq, c = cq;
        forn(i, n) {
            r += dx[d];
            c += dy[d];
            if (r < 0 || c < 0 || r >= n || c >= n || t.count({r, c})) break;
            res++;
        }
    }
    cout << res;

}
