#include <iostream>
#include <cstdio>
#include <string.h>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <sstream>
#include <cmath>
#include <ctime>
#include <bitset>

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

struct fence {
    int id, x1, y1, x2, y2;

    fence() {};

    fence(int id, int x1, int y1, int x2, int y2) : id(id), x1(x1), y1(y1), x2(x2), y2(y2) {}

    bool operator<(const fence &other) const {
        return id < other.id;
    }

    bool inside(int x, int y) {
        return x >= x1 && x <= x2 && y > y1 && y <= y2;
    }
};

int main() {
    int n, q;
    cin >> n >> q;
    vi x, y;
    forn(i, n) {
        int px, py;
        cin >> px >> py;
        x.pb(px);
        y.pb(py);
    }
    int cnt = 0;
    set<fence> s;
    forn(i, q) {
        string req;
        cin >> req;
        if (req[0] == 'd') {
            int pos;
            cin >> pos;
            fence f;
            f.id = pos - 1;
            s.erase(f);
        }
        if (req[0] == 'a') {
            int x1, y1, x2, y2;
            cin >> x1 >> y1 >> x2 >> y2;
            fence f(i, x1, y1, x2, y2);
            s.insert(f);
        }
        if (req[0] == 'q') {
            int p1, p2;
            cin >> p1 >> p2;
            p1--;
            p2--;
            bool ok = true;
            for (auto f:s) {
                if ((f.inside(x[p1], y[p1]) ^ f.inside(x[p2], y[p2]))) {
                    ok = false;
                    break;
                }
            }
            if (ok) cout << "YES"; else cout << "NO";
            cout << endl;
        }
    }

}