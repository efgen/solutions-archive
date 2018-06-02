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
	vector<double> v;	
	double n;
	while (cin>>n)	v.push_back(n);
	int k = v.size();
	while (k>0) 
	{	k--;
		printf("%0.4f\n",sqrt(v[k]));
	}
	return 0;
}