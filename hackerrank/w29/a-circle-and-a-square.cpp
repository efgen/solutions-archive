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

int sq(int x) {return x*x; }

int area(int x1, int y1, int x2, int y2, int x3, int y3) {
    x2 -= x1; y2 -= y1;
    x3 -= x1; y3 -= y1;
    return abs(x2*y3-x3*y2);
}

bool inside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
    return area(x, y, x1, y1, x2, y2) +
        area(x, y, x1, y1, x3, y3)  +
        area(x, y, x3, y3, x2, y2)  ==
        area(x1, y1, x2, y2, x3, y3);
}

int main() {
    int w, h, x1, y1, x2, y2, r, xc, yc;
    cin >> w >> h >> xc >> yc >> r >> x1 >> y1 >> x2 >> y2;
    x1 *= 2;
    y1 *= 2;
    x2 *= 2;
    y2 *= 2;
    xc *= 2;
    yc *= 2;
    r *= 2;
    r = sq(r);
    
    int v1x = (x2-x1)/2;
    int v1y = (y2-y1)/2;
    
    int x3 = x1 + v1x - v1y;
    int y3 = y1 + v1y + v1x;
    
    int x4 = x1 + v1x + v1y;
    int y4 = y1 + v1y - v1x;
    
    //cout << x3 << " " << y3 << " " << x4 << " " << y4 << endl;
    
    forn(j, h) {
        forn(i, w) {
            int x = 2*i;
            int y = 2*j;
            bool ok = sq(x-xc)+sq(y-yc) <= r;
            ok |= inside(x1, y1, x3, y3, x2, y2, x, y);
            ok |= inside(x1, y1, x4, y4, x2, y2, x, y);
            cout << (ok ? "#" : ".");
        }
        cout << endl;
    }
    
}
