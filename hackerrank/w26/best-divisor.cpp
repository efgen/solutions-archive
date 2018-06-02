#include <bits/stdc++.h>

using namespace std;

int f(int x) {
	int r = 0;
	while (x) {
		r += x % 10;
		x /= 10;
	}
	return r;
}

int main() {
	int n;
	cin >> n;
	int best = 1;
	int sum = 1;
	for (int d = 1; d * d <= n; d++) {
		if (n % d == 0) {
			int s = f(d);
			if (s > sum || (s == sum && d < best)) {
				best = d;
				sum = s;
			}
			s = f(n / d);
			if (s > sum || (s == sum && n / d < best)) {
				best = n / d;
				sum = s;
			}
		}
	}
	cout << best;
	return 0;
}
