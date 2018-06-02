package main

import (
	"fmt"
)

var N = 26
var A = make([]int, 26)

func CodeToRune(x int) int {
	return ('a'+x)
}

func PrintAll() {
	for i:=0; i<N; i++ {
		for A[i] > 0 {
			fmt.Printf("%c", 'a'+i)
			A[i]--
		}
	}
}

func PrintOneFrom(x int) {
	for i:=x+1; i<N; i++ {
		if (A[i] > 0) {
			fmt.Printf("%c", CodeToRune(i))
			A[i]--
			break 
		}
	}
}

func main() {

	var tmp int
	position := -1
	firstLPosition := -1
	for i:=0; i<N; i++ {
		fmt.Scanf("%d", &tmp)
		A[i] = tmp
		if (A[i] > 0) && (position<0 || A[i] < A[position]) {
			position = i
		}
		if firstLPosition < 0 && A[i] > 0 {
			firstLPosition = i
		}
	}
	
	fmt.Printf("%c", 'a'+position)
	A[position]--
	
	if (position == firstLPosition) {
		for A[position] > 0 {
			fmt.Printf("%c", 'a'+position)
			A[position]--
			PrintOneFrom(position)			
		}
		PrintAll()
	} else {
		PrintAll()	
	}
	
		
	

//	fmt.Printf("Min freq=%d Letter=%c \n", A[position], CodeToRune(position))




}
