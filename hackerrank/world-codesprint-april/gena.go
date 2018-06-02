package main

import (
	"fmt"
    "strings"
    "strconv"
)
var N int8

type Position struct {
	BinaryCode uint32 // 00(3D) 11(2D) 00(1D)
	Rods []int8
}


var Result = make(map[uint32]int, 0)

func Move(BinaryCode uint32) int{

	if BinaryCode == 0 {
        //fmt.Println("EXIT")
		return 0
	}

	best := 1<<30
	if _, found := Result[BinaryCode]; found {
		return Result[BinaryCode];
	}
	Result[BinaryCode] = best

	Rods := []int8{N, N, N, N}

	x := BinaryCode
	var i int8
	for i=0; i<N; i++ {
		key := x&3
		Rods[key] = N-1-i
		x = x >> 2
	}

    nextMoves := []uint32{}
    
	for i:=0; i<4; i++ {
		if Rods[i] == N { continue }
		for j:=0; j<4; j++ {
			if Rods[j] > Rods[i]  {
				diskNumber := uint32(Rods[i])
               // diskNumber = uint32(N)-1-diskNumber
                diskNumber = 2*diskNumber

				//

				                
                bcStr := fmt.Sprintf("%b", BinaryCode)
                gap := 2*N - int8(len(bcStr))
                if gap > 0 {
                    bcStr = strings.Repeat("0", int(gap)) + bcStr
                }
                s := bcStr[0:diskNumber] + fmt.Sprintf("%02b", j) + bcStr[diskNumber+2:]
                
                newB, _ := strconv.ParseInt(s, 2, 0)
                newBinaryCode := uint32(newB)
                
                
              //  fmt.Printf("FROM rod %d TO rod %d DISK %d  \n", i, j,Rods[i])	
                //fmt.Printf("BC: %06b  str=%s NBC: %06b \n\n", BinaryCode, s, newBinaryCode)		
                
                nextMoves = append(nextMoves, newBinaryCode)
			}
		}
	}
    
    var v uint32
    for _, v = range nextMoves {
        res := Move(v)
		if res < best {
			best = res
		}
    }

	best++
	//fmt.Printf("%06b best=%d\n", BinaryCode, best)
	Result[BinaryCode] = best

	return best
}


func main() {
	var binaryCode uint32
	var x int
	fmt.Scanf("%d", &N)
	var i int8
	for i=0; i<N; i++ {
		fmt.Scanf("%d", &x)
		x--
		binaryCode = binaryCode << 2 | uint32(x)
	}

	fmt.Print(Move(binaryCode))



}
