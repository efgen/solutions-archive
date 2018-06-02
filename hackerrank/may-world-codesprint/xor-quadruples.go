package main
import (
    "fmt"
    "sort"
)

type Pair struct {
    X, Y int
}

type NameSorter []Pair

func (a NameSorter) Len() int           { return len(a) }
func (a NameSorter) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a NameSorter) Less(i, j int) bool { 
    if a[i].Y == a[j].Y {
        return a[i].X < a[j].X 
    }
    
    return a[i].Y < a[j].Y 
}

func main() {
    arr := make([]int, 4)
    
    for i:=0; i<4; i++ {
        fmt.Scanf("%d", &arr[i])
    }
    
    sort.Ints(arr)
    
    //fmt.Printf("arr: %+v \n", arr)
    
    map23 := map[int]int{}
    var totalPairs int
    
    mapStart := 1
    
    for x:=1; x<=arr[2]; x++ {
        for y:=x; y<=arr[3]; y++ {
            t := x ^ y
            
            if _, found := map23[t]; !found {
                map23[t] = 1
            } else {
                map23[t] += 1
            }
            totalPairs++
        }
    }
    
    answer := 0
    
    pairs := []Pair{}
    
    for x:=1; x<=arr[0]; x++ {
        for y:=x; y<=arr[1]; y++ {
            pairs = append(pairs, Pair{
                X: x,
                Y: y,
            })
        }
    }
    
    sort.Sort(NameSorter(pairs))
    
    //fmt.Printf("Pairs: %+v \n", pairs)
    
    for _, pair := range pairs {
        x := pair.X
        y := pair.Y
        
        t := x ^ y
        
        if mapStart < y {
            for z:=mapStart; z<y; z++ {
                for zz:=z; zz<=arr[3]; zz++ {
                    t2 := z ^ zz
                    map23[t2]--
                    totalPairs--
                }
            }
            
            mapStart = y
        }
            
        res, found := map23[t]
        if !found {
            res = 0
        }

        answer += totalPairs-res
    }
        
    fmt.Println(answer)
}