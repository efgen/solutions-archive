package main

import (
	"fmt"
)

func main() {
	var n, jumps int
	c := []int{}
	
	fmt.Scanf("%d", &n)
	for i:=0; i<n; i++ {
		var x int
		fmt.Scanf("%d", &x)
		c = append(c, x)
	}

	
	for i:=0; i<n-1; {
		if (i+2 < n) && (c[i+2] == 0) {
			jumps += 1
			i += 2
			continue
		} 
		if (i+1 < n) && (c[i+1] == 0) {
			jumps += 1
			i += 1
		} 
      //  fmt.Println(i)
	}
	fmt.Print(jumps)
	
}
