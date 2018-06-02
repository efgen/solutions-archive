package main
import "fmt"

type Node struct {
    Coins  int
    Edges  []int
    Level  int
    Nim1   int  // 
    Nim2   int
   // Parent int
    Pre, Post int
}

var (
    Nodes = make([]*Node, 0)
    N, Q, TimeIn, TimeOut int
    IWasHere = make(map[int]bool, 0)
)

func Calc(u int) {
    TimeIn++
    IWasHere[u] = true
    
    Nodes[u].Nim2 = Nodes[u].Coins
    Nodes[u].Pre = TimeIn
    
    for _, v := range Nodes[u].Edges {
        if _, ok := IWasHere[v]; ok {
            continue
        }
        
        Nodes[v].Level = Nodes[u].Level + 1
       // Nodes[v].Parent = u
        
        Calc(v)
        
        Nodes[u].Nim2 = Nodes[u].Nim2 ^ Nodes[v].Nim1
        Nodes[u].Nim1 = Nodes[u].Nim1 ^ Nodes[v].Nim2
    }
    
    TimeOut++
    Nodes[u].Post = TimeOut
}

/*func IsValidGraph(u int) bool { 
    startU := u
    for u>0 {
        u = Nodes[u].Parent
        if u == startU {
            return false
        }
    }
    return true
}*/

func IsAncestor(u, v int) bool {
    return (Nodes[u].Pre < Nodes[v].Pre) && (Nodes[u].Post > Nodes[v].Post)
}
    
func main() {
 //Enter your code here. Read input from STDIN. Print output to STDOUT
    fmt.Scanf("%d", &N)
    
    for i:=0; i<N; i++ {
        node := &Node{
            Edges: make([]int, 0),
        }
        Nodes = append(Nodes, node)
    }
    
    // read coins
    for i:=0; i<N; i++ {
        fmt.Scanf("%d", &Nodes[i].Coins)
    }
    
    var x, y int
    for i:=1; i<N; i++ {
        fmt.Scanf("%d%d", &x, &y)
        x--
        y--
        Nodes[x].Edges = append(Nodes[x].Edges, y)
        Nodes[y].Edges = append(Nodes[y].Edges, x)
    }
    
    fmt.Scanf("%d", &Q)
    
    Calc(0)
    
    var u, v int
    for i:=0; i<Q; i++ {
        fmt.Scanf("%d%d", &u, &v)
        u--
        v--
                
        //oldParent := Nodes[u].Parent
       //Nodes[u].Parent = v
        
        isAnsc := IsAncestor(u, v)
        
        //Nodes[u].Parent = oldParent
        
        if isAnsc {
            fmt.Println("INVALID")
        } else {
            nimValue := Nodes[0].Nim1
            if Nodes[u].Level % 2 != (Nodes[v].Level + 1) % 2 {
                nimValue = nimValue ^ Nodes[u].Nim1 ^ Nodes[u].Nim2
            }
            
            if nimValue == 0 {
                fmt.Println("NO")
            } else {
                fmt.Println("YES")
            }
        }
    }
  //  
  //  for key, v := range Nodes {
   //     fmt.Printf("Node %d: %+v \n", key, v)
  //  }
    
}