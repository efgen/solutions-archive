#include <bits/stdc++.h>

using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	n++;
	m++;
	n >>= 1;
	m >>= 1;
	cout << n * m;
	return 0;
}
