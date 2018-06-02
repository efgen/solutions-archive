package main

import (
	"fmt"
	"math/rand"
)

type Treap struct {
	root    *node
}

var Answer [100001]int

type node struct {
	id       int
	priority int
	cnt	 int
	left     *node
	right    *node
}

func NewTreap() *Treap {
	return &Treap{root: nil}
}


func (t *Treap) Upsert(itemId int, itemPriority int) *Treap {
	r := t.union(t.root, &node{id: itemId, priority: itemPriority, cnt:1})
	return &Treap{root: r}
}

func (t *Treap) union(this *node, that *node) *node {
	if this == nil {
		return that
	}
	if that == nil {
		return this
	}



	if this.priority > that.priority {
		this.right = t.union(this.right, that)
		t.updateCnt(this)
		return this;
	} else {
		that.left = t.union(this, that.left)
		t.updateCnt(that)
		return that;
	}



}
func (t *Treap) split(n *node, key int, add int) (*node, *node) {
	if n == nil {
		return nil, nil
	}
	curKey := add + t.cnt(n.left)
	var res *node;

	if (key <= curKey) {
		left, right := t.split(n.left, key, add)
		res = &node{
			id: n.id,
			priority: n.priority,
			left: right,
			right: n.right,
		}
		t.updateCnt(res);
		return left, res
	} else {
		left, right := t.split(n.right, key, add + 1 + t.cnt(n.left))
		res = &node{
			id: n.id,
			priority: n.priority,
			left: n.left,
			right: left,
		}
		t.updateCnt(res);
		return res, right
	}
}

func (t *Treap) cnt(n *node) int {
	if n != nil {
		return n.cnt
	}
	return 0;
}

func (t *Treap) updateCnt(n *node) {
	if n != nil {
		n.cnt = 1 + t.cnt(n.left) + t.cnt(n.right)
	}
}


func (t *Treap) toFront(n *node, l int, r int) {
	l--
	node := t.root
	t1, t2 := t.split(node, r, 0)
	t3, t4 := t.split(t1, l, 0)
	node = t.union(t4, t3)
	node = t.union(node, t2)
	t.root = node
}

func (t *Treap) traverse(n *node, add int)  {
	if n != nil {
		Answer[add + t.cnt(n.left)] = n.id
		t.traverse(n.left, add)
		t.traverse(n.right, add + t.cnt(n.left) + 1)
	}
}

func main() {

	var n, m int
	t := NewTreap()
	fmt.Scanf("%d", &n)
	for i:=0; i<n; i++ {
		var id int
		fmt.Scanf("%d", &id)
		t = t.Upsert(id, rand.Int())
	}

	fmt.Scanf("%d", &m)
	for i:=0; i<m; i++ {
		var l, r int
		fmt.Scanf("%d%d", &l, &r)
		t.toFront(t.root, l, r)
	}

	t.traverse(t.root, 0)

	for i:=0; i<n; i++ {
		fmt.Print(Answer[i])
		fmt.Print(" ");
	}


}
