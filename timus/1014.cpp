#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <stack>
#include <math.h>
#include <stdio.h>
using namespace std;

int main()
{
	vector<int> v;
	int n;	
	cin >> n;
	if (n==0) 
	{
		cout << 10;
		return 0;
	} else
	if (n==1)
	{
		cout << 1;
		return 0;
	}
	string s = "";
	while (n>1) {
		bool f = false;
		for (int p=9; !f && p>1; p--)
			if (n%p==0) {
				n /= p;
				v.push_back(p);				
				f = true;
			}
		if (!f) 
		{
			cout << -1;
			return 0;
		}		
	}
	int k = (int) v.size();
	while (k>0) cout << v[--k];

	return 0;
}