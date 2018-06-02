package main

import (
	"fmt"
)

func main() {
	var n, d, res int
	a := make(map[int]bool, 0)
	

	fmt.Scanf("%d%d", &n, &d)
	for i:=0; i<n; i++ {
		var x int
		fmt.Scanf("%d", &x)
		a[x] = true
	}
	
	for k, _ := range a {
		_, found1 := a[k+d]
		_, found2 := a[k+2*d]
		if found1 && found2 {
			res++
		}			
			
		
	} 


	fmt.Print(res)

}
