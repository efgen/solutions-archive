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

int main() {
    int n;
    double d;
    cin >> n >> d;
    vector<double> x(n);
    vector<double> y(n);
    forn(i, n) {
        cin >> x[i] >> y[i];
    }
    vector<double> mx, my, val;
    vi mid;
    forn(i, n) {
        double p = 0, s = 0, cx = 0, cy = 0;
        forn(j, n) {
            cx += x[j];
            cy += y[j];
        }
        cx /= n;
        cy /= n;
        int bid = 0;
        double best = 1e+100;
        forn(j, n) {
            double d = hypot(x[j] - cx, y[j] - cy);
            if (d < best) {
                best = d;
                bid = j;
            }
        }
        double vx = x[bid] - cx;
        double vy = y[bid] - cy;
        double norm = hypot(vx, vy);
        vx *= (d+norm) / norm;
        vy *= (d+norm) / norm;
        x[bid] = cx + vx;
        y[bid] = cy + vy;
        mx.pb(x[bid]);
        my.pb(y[bid]);
        mid.pb(bid);

        forn(j, n) {
            p += hypot(x[(j + 1) % n] - x[j], y[(j + 1) % n] - y[j]);
            s += x[j] * y[(j + 1) % n] - x[(j + 1) % n] * y[j];
        }
        s = abs(s / 2);
        double score = p * p / s;
        val.pb(score);
    }

    int res = 0;
    forn(i, n) {
        if (val[i]<val[res]) {
            res = i;
        }
    }
    cout << res << endl;
    forn(i, res) {
        cout << mid[i] + 1 << " " << mx[i] << " " << my[i] << endl;
    }
}
