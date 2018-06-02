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

const double eps = 1E-9;

struct point {
    double x, y;

    point() : x{0}, y{0} {}

    point(double x, double y) : x{x}, y{y} {}

    bool operator<(const point &p) const {
        return x < p.x - eps || (abs(x - p.x) < eps && y < p.y - eps);
    }

    point operator-(const point &p) {
        return point(x - p.x, y - p.y);
    }
};

struct segment {
    point a, b;

    segment(point a, point b) : a{a}, b{b} {}
};

double cross(point p1, point p2) {
    return p1.x * p2.y - p1.y * p2.x;
}

double dot(point p1, point p2) {
    return p1.x * p2.x + p1.y + p2.y;
}

bool intersect(point p0, point p1, point p2, point p3, point *res) {
    point v1 = p1 - p0;
    point v2 = p3 - p2;
    point v = p0 - p2;
    double s = cross(v1, v);
    double t = cross(v2, v);
    double st = cross(v1, v2);
    s /= st;
    t /= st;
    if (s > eps && s + eps < 1 && t > eps && t + eps < 1) {
        *res = point(p0.x + t * v1.x, p0.y + t * v1.y);
        return true;
    }
    return false;
}

bool isEqual(double a, double b) {
    return abs(a - b) < eps;
}

int main() {
    int n;
    cin >> n;
    vector<segment> all;
    vector<point> events;
    forn(i, n) {
        double x1, x2, x3;
        double y1, y2, y3;
        cin >> x1 >> y1;
        cin >> x2 >> y2;
        cin >> x3 >> y3;
        point p1{x1, y1};
        point p2{x2, y2};
        point p3{x3, y3};
        point p21 = p2 - p1;
        point p31 = p3 - p1;
        if (cross(p21, p31) < 0) {
            point t = p2;
            p2 = p3;
            p3 = t;

        }
        segment s1{p1, p2};
        segment s2{p2, p3};
        segment s3{p3, p1};
        all.pb(s1);
        all.pb(s2);
        all.pb(s3);
        events.pb(p1);
        events.pb(p2);
        events.pb(p3);
    }
    for (int i = 0; i < 3 * n; i++)
        for (int j = i + 1; j < 3 * n; j++) {
            point p;
            if (intersect(all[i].a, all[i].b, all[j].a, all[j].b, &p)) {
                events.pb(p);
            }
        }
    sort(all(events));
    vector<double> xs;
    for (auto p:events)
        xs.pb(p.x);
    sort(all(xs));
    xs.erase(unique(xs.begin(), xs.end(), &isEqual), xs.end());

    double res = 0;
    cout.precision(6);
    for (int i = 0; i < xs.size() - 1; i++) {
        double x = (xs[i + 1] + xs[i]) / 2;
        vector<pair<double, int>> ys;
        for (auto s:all) {
            point p = s.b - s.a;
            if (abs(p.x) < eps) continue;
            if (x < min(s.a.x, s.b.x) || x > max(s.a.x, s.b.x)) continue;
            double y = s.a.y + p.y / p.x * (x - s.a.x);
            ys.pb(mp(y, p.x > 0 ? 1 : -1));
        }
        sort(all(ys));
        double lasty = -10, sum = 0;
        int cnt = 0;
        for (auto y : ys) {
            //cout << "(" << y.first << "," << y.second << ") ";
            if (cnt == 0 && y.second > 0) {
                lasty = y.first;
            }
            if (cnt == 1 && y.second < 0) {
                sum += y.first - lasty;
            }
            cnt += y.second;

        }
        //cout << endl;
        //cout << sum << endl;
        res += sum * (xs[i + 1] - xs[i]);
    }


    cout << res;
}