package study.structure;

public class MyBinaryTree {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;
        public Node(int data) {
            this.value = data;
            left = null;
            right = null;
        }
    }

    public void insertDate(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node node = head;
            while (true) {
                if (node.value > data) {
                    if (node.left == null) {
                        node.left = new Node(data);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Node(data);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
    }

    public Node searchData(int data) {
        if (head != null) {
            Node node = head;
            while (node != null) {
                if (node.value == data) {
                    return node;
                }
                if (node.value > data) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }

    public boolean removeData(int data) {
        Node currNode = head;
        Node currParentNode = head;
        boolean searched = false;

        if (head == null) {
            return false;
        }

        if (head.value == data && head.left == null && head.right == null) {
            head = null;
            return true;
        }

        while (currNode != null) {
            if (currNode.value == data) {
                searched = true;
                break;
            } else if (currNode.value > data) {
                currParentNode = currNode;
                currNode = currNode.left;
            } else {
                currParentNode = currNode;
                currNode = currNode.right;
            }
        }

        if (!searched) {
            return false;
        }

        if (currNode.left == null && currNode.right == null) {
            if (currParentNode.value > data) {
                currParentNode.left = null;
            } else {
                currParentNode.right = null;
            }
            return true;

        } else if (currNode.left != null && currNode.right == null) {
            if (currParentNode.value > data) {
                currParentNode.left = currNode.left;
            } else {
                currParentNode.right = currNode.left;
            }
            return true;

        } else if (currNode.left == null) {
            if (currParentNode.value > data) {
                currParentNode.left = currNode.right;
            } else {
                currParentNode.right = currNode.right;
            }
            return true;

        } else {
            Node changeNode = currNode.right;
            Node changeParentNode = currNode.right;
            if (currParentNode.value > data) {
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right == null) {
                    changeParentNode.left = null;
                } else {
                    changeParentNode.left = changeNode.right;
                }

                currParentNode.left = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

            } else {
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right == null) {
                    changeParentNode.left = null;
                } else {
                    changeParentNode.left = changeNode.right;
                }

                currParentNode.right = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insertDate(3);
        tree.insertDate(2);
        tree.insertDate(4);
        tree.insertDate(6);
        tree.insertDate(1);
        tree.insertDate(7);

        System.out.println(tree.searchData(4).value);
        System.out.println(tree.removeData(6));
        System.out.println(tree.searchData(4).right.value);
    }
}
