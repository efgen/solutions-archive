#include <iostream>   
#include <algorithm>
#include <stdio.h>   
using namespace std;   
const int maxn = 2000;

int gcd2(int a, int b) {	
	if (a<0) a = -a;
	if (b<0) b = -b;
	while (a!=0 && b!=0) {
		if (a>b) a %= b; else b %= a;
	}
	return a+b;
}
int gcd(int a, int b) {	
	if (a<b) {
		int q = a; a = b; b = q;
	}
	while (b>0) {
		int q = b;
		b = a%b;
		a = q;		
	}
	return a;
}
struct point {
	int x,y,z;
	point(){};
	point(int _x,int _y,int _z):x(_x),y(_y),z(_z){};
	bool operator==(const point &b) {	
		return (x==b.x) && (y==b.y) && (z==b.z);
	}
	bool operator<(const point &b) {
		if (x<b.x) return true;
		if (x==b.x)
			if (y<b.y) return true;
				else if (y==b.y) return (z<b.z);
		return false;
	}
}; 



int main() {   
 //   freopen("input.txt", "r", stdin);   
  //  freopen("output.txt", "w", stdout);
	int n;
	int X[maxn];
	int Y[maxn];
	int Z[maxn];
	point a[maxn+1];
	scanf("%d",&n);
	for (int i=0; i<n; i++) scanf("%d%d%d",&X[i],&Y[i],&Z[i]);	
	int res = 1;
	a[n] = point(1<<31,1<<31,1<<31);
	for (int i=0; i<n; i++) {
		int bx = X[i], by = Y[i], bz = Z[i];
		for (int j=0; j<n; j++) {
			int x = X[j]-bx, y = Y[j]-by, z = Z[j]-bz;
			int d = gcd(abs(z),gcd(abs(x),abs(y)));
			if (d>1) {
				x /= d; y /= d ; z /= d;
			}
			
			a[j] = point(x,y,z);
		}			
		sort(a,a+n);	
		int p = 1;
		while (p<n) {
			int r = 2;
			while (a[p-1]==a[p]) {
				p++; r++;
			}
			if (r>res) res = r;
			p++;
		}
	}
	cout << res;
    return 0;   
}   