package leetcode;

public class sol1361 {
    class Node {
        public int parent;
        public int left;
        public int right;

        public Node() {
            this.parent = -1;
            this.left = -1;
            this.right = -1;
        }
    }

    private Node[] tree;
    private boolean[] visited;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        tree = new Node[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            tree[i] = new Node();
            visited[i] = false;
        }

        for(int i=0; i<n; i++) {
            if(leftChild[i] >= 0) {
                tree[i].left = leftChild[i];

                if(tree[leftChild[i]].parent >= 0) return false;
                tree[leftChild[i]].parent = i;
            }

            if(rightChild[i] >= 0) {
                tree[i].right = rightChild[i];

                if(tree[rightChild[i]].parent >= 0) return false;
                tree[rightChild[i]].parent = i;
            }
        }

        int head = -1;
        for(int i=0; i<n; i++) {
            if(tree[i].parent == -1) {
                head = i;
                break;
            }
        }

        if(head < 0) return false;
        dfs(head);

        for(int i=0; i<n; i++)
            if(!visited[i]) return false;

        return true;
    }

    private void dfs(int node) {
        visited[node] = true;

        if(tree[node].left >= 0) dfs(tree[node].left);
        if(tree[node].right >= 0) dfs(tree[node].right);
    }
}
