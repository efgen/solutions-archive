using namespace std;
vector<vector<int>> g;
vector<int> values;
vector<Color> colors;
const long long mod = 1000000000 + 7;

class SumInLeavesVisitor : public TreeVis {
private:
    int value = 0;
public:
    int getResult() {
        return this->value;
    }

    void visitNode(TreeNode *node) {
    }

    void visitLeaf(TreeLeaf *leaf) {
        this->value += leaf->getValue();
    }
};


class ProductOfRedNodesVisitor : public TreeVis {
private:
    int value = 1;

    void update(int v) {
        long long r = (long long) v * this->value;
        this->value = (int) (r % mod);
    }

public:
    int getResult() {
        return this->value;
    }

    void visitNode(TreeNode *node) {
        if (node->getColor() == RED) {
            this->update(node->getValue());
        }
    }

    void visitLeaf(TreeLeaf *leaf) {
        if (leaf->getColor() == RED) {
            this->update(leaf->getValue());
        }
    }

};

class FancyVisitor : public TreeVis {
private:
    int greenLeaf = 0;
    int evenNode = 0;
public:
    int getResult() {
        return abs(this->greenLeaf - this->evenNode);
    }

    void visitNode(TreeNode *node) {
        if (node->getDepth() % 2 == 0) {
            this->evenNode += node->getValue();
        }
    }

    void visitLeaf(TreeLeaf *leaf) {
        if (leaf->getColor() == GREEN) {
            this->greenLeaf += leaf->getValue();
        }
    }
};

Tree *dfs(int v, int p, int dep) {
    if (dep != 0 && g[v].size() == 1) {
        return new TreeLeaf(values[v], colors[v], dep);
    }

    TreeNode *t = new TreeNode(values[v], colors[v], dep);
    for (int u:g[v]) {
        if (u != p) {
            t->addChild(dfs(u, v, dep + 1));
        }
    }
    return t;
}

Tree *solve() {

    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        values.push_back(x);
    }
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        colors.push_back(x == 0 ? RED : GREEN);
    }
    g.assign(n, vector<int>());
    for (int i = 1; i < n; i++) {
        int x, y;
        scanf("%d%d", &x, &y);
        x--;
        y--;
        g[x].push_back(y);
        g[y].push_back(x);
    }

    return dfs(0, -1, 0);


}