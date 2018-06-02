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

int n;
int a[32][32], b[32][32];

void rotate(int px, int py, int k) {
	for (int x = k / 2 - 1; x >= 0; --x) {
		for (int y = x; y < k - x - 1; y++) {
			int temp = a[px + x][py + y];
			a[px + x][py + y] = a[px + k - 1 - y][py + x];
			a[px + k - 1 - y][py + x] = a[px + k - 1 - x][py + k - 1 - y];
			a[px + k - 1 - x][py + k - 1 - y] = a[px + y][py + k - 1 - x];
			a[px + y][py + k - 1 - x] = temp;
		}
	}
}

pii find(int val) {
	forn(i, n) {
		forn(j, n) {
			if (a[i][j] == val) return {i, j};
		}
	}
	return {-1, -1};
}

int score() {
	int res = 0;
	forn(i, n) {
		forn(j, n) {
			int t = a[i][j];
			for (int x = i + 1; x < n; x++)
				if (t < a[x][j]) res++;
			for (int y = j + 1; y < n; y++) {
				if (t < a[i][y]) res++;
			}
		}
	}
	return res;
}

int main() {
	const clock_t begin_time = clock();
	vvi preRotate;
	cin >> n;
	int px = -1, py = -1;
	forn(i, n) forn(j, n) {
			cin >> a[i][j];
		}
	int maxIt = 500 - 1;

	auto pos = find(1);
	px = pos.first;
	py = pos.second;

	if (px != 0 || py != 0) {
		int t = min(px, py);
		if (t) {
			rotate(px - t, py - t, t + 1);
			rotate(px - t, py - t, t + 1);
			preRotate.pb(vi{px - t, py - t, t + 1});
			preRotate.pb(vi{px - t, py - t, t + 1});
			px -= t;
			py -= t;
			maxIt -= 2;
		}
		if (px == 0 && py != 0) {
			forn(i, 3) {
				rotate(0, 0, py + 1);
				preRotate.pb(vi{0, 0, py + 1});
				maxIt--;
			}
		}
		if (px != 0 && py == 0) {
			rotate(0, 0, px + 1);
			preRotate.pb(vi{0, 0, px + 1});
			maxIt--;
		}
	}

	for (int k = 1; k <= 2 * n && maxIt > 0; k++) {
		for (int j = k; j >= 0 && maxIt > 0; --j) {
			int i = k - j;
			if (i < n && j < n) {
				int bx = 0, by = 0;
				int t = 0;
				while (i + t < n && j + t < n) {
					for (int q = 0; q <= t; q++)
						if (a[i + t][j + q] < a[i + bx][j + by]) {
							bx = t;
							by = q;
						}
					t++;
				}
				if (a[i][j] > a[i + bx][j + by]) {
					if (by) {
						rotate(i + bx - by, j, by + 1);
						preRotate.pb(vi{i + bx - by, j, by + 1});
						maxIt--;
					}
					rotate(i, j, bx + 1);
					preRotate.pb(vi{i, j, bx + 1});
					maxIt--;
				}
			}
		}
	}


	forn(i, n) {
		forn(j, n) {
			b[i][j] = a[i][j];
		}
	}
//	forn(i, n) {
//		forn(j, n) {
//			cout << a[i][j] << " ";
//		}
//		cout << endl;
//	}
//	exit(0);

	//cout << score() << endl;

	vvi path, best_path;
	int best = 0, res = 0, bestRes = 0, bestSc = 0;
	while (true) {
		if (clock() - begin_time > 1970000) break;
		forn(i, n) {
			forn(j, n) {
				a[i][j] = b[i][j];
			}
		}
		path.resize(0);
		forn(i, maxIt) {
			int k = rand() % (n - 2) + 2;
			int x = rand() % (n - k + 1);
			int y = rand() % (n - k + 1);
			if (x == 0 && y == 0) continue;
			rotate(x, y, k);
			path.pb(vi{x, y, k});
			int sc = score();
			if (sc > best) {
				best = sc;
				res = path.size();
			}

		}
		if (best > bestSc) {
			bestSc = best;
			best_path = path;
			bestRes = res;
		}
	}
	path = best_path;
	res = bestRes;
	cout << res + preRotate.size() << endl;
	for (auto v:preRotate) {
		cout << v[0] + 1 << " " << v[1] + 1 << " " << v[2] << endl;
	}

	for (int i = 0; i < res; i++) {
		cout << path[i][0] + 1 << " " << path[i][1] + 1 << " " << path[i][2] << endl;
	}
	//cout << best << endl;

}
