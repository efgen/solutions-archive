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

bool checkPos(const vector<vector<char> > &board, int px, int py, const vector<pii> &moves) {
    const int n = 8;
    for (auto delta:moves) {
        int x = px;
        int y = py;
        forn(i, n) {
            x += delta.X;
            y += delta.Y;
            if (x < 0 || y < 0 || x >= n || y >= n) break;
            if (board[x][y] == 'k') return true;
            if (board[x][y] != '#') break;
        }
    }
    return false;
}

const vector<pii> lin = {{0,  1},
                         {0,  -1},
                         {1,  0},
                         {-1, 0}};
const vector<pii> dia = {{1,  1},
                         {-1, -1},
                         {1,  -1},
                         {-1, 1}};

bool checkBoard(const vector<vector<char> > &board) {
    const int n = 8;
    forn(i, n) forn(j, n) {
            if (board[i][j] == 'Q' || board[i][j] == 'R') {
                if (checkPos(board, i, j, lin)) return true;
            }
            if (board[i][j] == 'Q' || board[i][j] == 'B') {
                if (checkPos(board, i, j, dia)) return true;
            }
        }
    return false;
}


int sign(int x) {
    return x > 0 ? 1 : (x < 0 ? -1 : 0);
}

int check(const vector<vector<char> > &board, int x, int y, int dx, int dy) {
    int n = 8;
    int tx = abs(x - dx);
    int ty = abs(y - dy);
    if ((tx == 1 && ty == 2) || (tx == 2 && ty == 1)) return 1;
    tx = sign(dx - x);
    ty = sign(dy - y);

    while (x != dx || y != dy) {
        x += tx;
        y += ty;
        if (x >= n || y >= n || x < 0 || y < 0) return 0;
        if (board[x][y] == '#' || board[x][y] == 'k') continue;
        return 0;
    }

    return 2;
}


int waysToGiveACheck(vector<vector<char> > &board) {
    int res = 0;
    int n = 8;
    int kx = -1, ky = -1;
    forn(i, n) forn(j, n) {
            if (board[i][j] == 'k') {
                kx = i;
                ky = j;
            }
        }
    forn(j, n) if (board[1][j] == 'P' && board[0][j] == '#') {
            board[1][j] = '#';
            board[0][j] = 'P';
            if (checkBoard(board)) return 4;
            int t = check(board, 0, j, kx, ky);
            board[0][j] = '#';
            board[1][j] = 'P';
            if (t > 0) return t;
        }
    return res;
}

int main() {
#ifdef EFGEN_DBG
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    int t;
    cin >> t;
    for (int a0 = 0; a0 < t; a0++) {
        vector<vector<char> > board(8, vector<char>(8));
        for (int board_i = 0; board_i < 8; board_i++) {
            for (int board_j = 0; board_j < 8; board_j++) {
                cin >> board[board_i][board_j];
            }
        }
        int result = waysToGiveACheck(board);
        cout << result << endl;
    }
    return 0;
}
