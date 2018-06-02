package main
import (
    "fmt"
    "sort"
)

var (
    InitialColor = []int{}
    Parent = []int{}
    Queries = [][]int{}
    Answer = []int{}   
     
    Color = []map[int]bool{}
    List = [][]int{}
    
    UsedV = []int{}
    
    SavedQ = []map[int][]int{}
)

type Edge struct {
    X, Y, U int
}

type NameSorter []Edge

func (a NameSorter) Len() int           { return len(a) }
func (a NameSorter) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a NameSorter) Less(i, j int) bool { 
    return a[i].U < a[j].U
}

type Query struct {
    X, Y, K int
}

func Find(v int) int {
    if Parent[v] == v {
        return v
    }
    
    Parent[v] = Find(Parent[v])
    return Parent[v]
}


func Second(q Query, v int) int {
    if q.X == v {
        return q.Y
    }
    return q.X
}


func main() {
    // n (the number of cities), m (the number of roads), and q (the number of queries). 
    
    var n, m, q int
    fmt.Scanf("%d %d %d", &n, &m, &q)
    
    InitialColor = make([]int, n+1)
    Parent = make([]int, n+1)
    Answer = make([]int, q)
    Queries = make([][]int, n+1)  
    Color = make([]map[int]bool, n+1)
    List = make([][]int, n+1)
    SavedQ = make([]map[int][]int, n+1)
    
    UsedV = make([]int, 0)
    
    var c int
    for i:=1; i<=n; i++ {
        fmt.Scanf("%d", &c)
        tmp := map[int]bool{}
        tmp[c] = true
        Color[i] = tmp
        InitialColor[i] = c
        
        Parent[i] = i
        Queries[i] = []int{}       
        List[i] = []int{i}
        SavedQ[i] = make(map[int][]int, 0)
        
    }
    
    edges := []Edge{}
    
    for i:=1; i<=m; i++ {
        edge := Edge{}
        fmt.Scanf("%d %d %d", &edge.X, &edge.Y, &edge.U)
        edges = append(edges, edge)
    }
    
    sort.Sort(NameSorter(edges))
    
   // fmt.Printf("Edges: %+v \n", edges)
      
    queries := []Query{}
    
    for i:=0; i<q; i++ {
        q := Query{}
        fmt.Scanf("%d %d %d", &q.X, &q.Y, &q.K)
        queries = append(queries, q)
        Queries[q.X] = append(Queries[q.X], i)
        Queries[q.Y] = append(Queries[q.Y], i)     
        
        Answer[i] = -1
    }
    
    //lastWeight := -1
    
    
    for _, e := range edges {
        px := Find(e.X)
        py := Find(e.Y)
        
        
        if px != py {
            oldSize := len(Color[px])
        
            
            if len(List[px]) < len(List[py]) {
                tmp := px
                px = py
                py = tmp
                oldSize = len(Color[px])
            }

            Parent[py] = px

            for _, v := range List[py] {
                List[px] = append(List[px], v)
                Color[px][InitialColor[v]] = true

                UsedV = append(UsedV, v)
            } 
            
            
        
            newC := px
            size := len(Color[newC])
            
            for i:=oldSize+1; i<=size; i++ {
                if qs, found := SavedQ[newC][i]; found {
                   for _, q := range qs {
                        
                        if Answer[q] == -1 {
                            Answer[q] = e.U
                        }
                        
                    }
                }
            }
            
                  
       
            
            for _, v:= range UsedV {            
                
                for _, q := range Queries[v] {
                    y := Second(queries[q], v)
                    qS := queries[q].K
                  //  fmt.Printf("q=%d y=%d find(y)=%d \n", q, y, Find(y))
                    if Find(y) == newC {
                        if size >= qS {
                            if Answer[q] == -1 {
                                 Answer[q] = e.U
                            }
                        } else {
                            if _, ok := SavedQ[newC][qS] ; !ok {
                                SavedQ[newC][qS] = make([]int, 0)
                            }
                            
                            if Answer[q] == -1 {
                                SavedQ[newC][qS] = append(SavedQ[newC][qS], q)
                            }
                        }
                    }
                }                 
            }
            UsedV = []int{}
        }

    }
    
    //sort.Sort(QuerySorter(queries))
    
    for _, a := range Answer {
        fmt.Println(a)
    }
    
   // fmt.Printf("Answer: %+v \n", Answer)
    
}