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

double fast(int n) {
	double min_e_cos = 1;
	double max_e_cos = 1;
	double min_o_cos = cos(0.5);
	double max_o_cos = cos(0.5);
	double res = -3;

	for (int a = 2; a < n; a++) {
		double c = cos((a - 2) / 2.0);
		if (a & 1) {
			min_o_cos = min(min_o_cos, c);
			max_o_cos = max(max_o_cos, c);
		} else {
			min_e_cos = min(min_e_cos, c);
			max_e_cos = max(max_e_cos, c);
		}
		double t = 2 * sin(a / 2.0);
		double min_c = a & 1 ? min_o_cos : min_e_cos;
		double max_c = a & 1 ? max_o_cos : max_e_cos;
		double cur = t > 0 ? t * max_c : t * min_c;
		res = max(res, cur + sin(n - a));
	}

	return res;
}

int main() {
	int n;
	cin >> n;
	printf("%0.9lf\n", fast(n));
}

