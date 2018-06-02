package main
import (
    "fmt"
    "sort"
)

type Pair struct {
  Pop int
  Id int
}

type PairList []Pair

func (p PairList) Len() int { return len(p) }
func (p PairList) Less(i, j int) bool {
    if p[i].Pop  == p[j].Pop {
        return p[i].Id < p[j].Id 
    }
    return p[i].Pop > p[j].Pop 
}
func (p PairList) Swap(i, j int){ p[i], p[j] = p[j], p[i] }

func main() {
    var K, M, N int
    fmt.Scanf("%d %d %d", &K, &M, &N)
    
    A := make(map[int]int, K)
    var a int
    for i:=0; i<N; i++ {
        fmt.Scanf("%d", &a)
        A[a] += 1
    }
    
    arr := PairList{}

    for key, v := range A {
        arr = append(arr, Pair{
            Pop: v,
            Id: key,
        })
    }
    
   sort.Sort(arr)
    
  //  fmt.Printf("A=%+v \n", arr)
    
    for i:=0; i<K; i++ {
        fmt.Println(arr[i].Id)
    }
    
}