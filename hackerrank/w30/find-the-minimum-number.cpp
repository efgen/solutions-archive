#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void f(int n) {
    if (n==2) {
        cout << "min(int, int)";
    } else {
        cout << "min(int, ";
        f(n-1);
        cout<<")";
            
    }
}
int main() {
    int x;
    cin >> x;
    f(x);
    return 0;
}
