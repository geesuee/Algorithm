// 트리 순회 구현 연습
// 코드 출처 : https://minhamina.tistory.com/80

package week5.tree.implement;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void createNode(int data, int leftData, int rightData) {
        if(root == null) {
            root = new Node(data);

            if (leftData != -1) {
                root.left = new Node(leftData);
            }
            if (rightData != -1) {
                root.right = new Node(rightData);
            }
        }else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node node, int data, int leftData, int rightData) {
        if(node == null) {
            return;
        }else if(node.data == data) {
            if(leftData != -1) {
                node.left = new Node(leftData);
            }
            if(rightData != -1) {
                node.right = new Node(rightData);
            }
        }else {
            searchNode(node.left, data, leftData, rightData);  // 오른쪽 재귀 탐색
            searchNode(node.right, data, leftData, rightData);  // 왼쪽 재귀 탐색
        }
    }

    // 전위순회 Preorder : Root -> Left -> Right
    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data + " ");
            if(node.left != null) {preOrder(node.left);}
            if(node.right != null) {preOrder(node.right);}
        }
    }

    // 중위순회 Inorder : Left -> Root -> Right
    public void inOrder(Node node) {
        if(node != null) {
            if(node.left != null) {inOrder(node.left);}
            System.out.print(node.data + " ");
            if(node.right != null) {inOrder(node.right);}
        }
    }

    // 후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) {postOrder(node.left);}
            if(node.right != null) {postOrder(node.right);}
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();

        t.createNode(1,2,3);
        t.createNode(2,4,5);
        t.createNode(5,6,7);

        System.out.println("전위 순회");
        t.preOrder(t.root);
        System.out.println("\n중위 순회");
        t.inOrder(t.root);
        System.out.println("\n후위 순회");
        t.postOrder(t.root);
    }
}
