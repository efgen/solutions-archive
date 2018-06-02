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
const int inf = 1000000000;

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    vi dx = {-2, -2, 0, 2, 2, 0};
    vi dy = {-1, 1, 2, 1, -1, -2};
    vs move_code = {"UL", "UR", "R", "LR", "LL", "L"};
    int n, sx, sy, fx, fy;
    cin >> n >> sx >> sy >> fx >> fy;
    vvi a(n, vi(n, inf));
    vector<vii> from(n, vii(n));
    vvi move(n, vi(n, inf));
    pii start = {sx, sy};
    queue<pii> q;
    q.push(start);
    a[sx][sy] = 0;
    bool found = false;
    while (!found && !q.empty()) {
        pii pos = q.front();
        q.pop();
        int d = a[pos.X][pos.Y];
        forn(i, 6) {
            int nx = pos.X + dx[i];
            int ny = pos.Y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (a[nx][ny] > d + 1) {
                a[nx][ny] = d + 1;
                from[nx][ny] = pos;
                move[nx][ny] = i;
                q.emplace(nx, ny);
                if (fx == nx && fy == ny) {
                    found = true;
                    break;
                }
            }
        }
    }
    if (a[fx][fy] == inf) {
        cout << "Impossible";
    } else {
        cout << a[fx][fy] << endl;
        pii pos = {fx, fy};
        stack<int> path;
        while (pos != start) {
            path.push(move[pos.X][pos.Y]);
            //cout << move_code[move[pos.X][pos.Y]] << " ";
            pos = from[pos.X][pos.Y];
        }

//
        while (!path.empty()) {
            int v = path.top();
            path.pop();
            cout << move_code[v] << " ";
        }

    }


    return 0;
}
