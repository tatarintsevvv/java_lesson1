package ru.geekbrains;

class Person {
    private String name;
    private int id;
    private int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println(name + " возраст:" + age + ", идентификатор:" + id);
    }

    public int getId() {
        return id;
    }
}

class Node {
    private Person person;
    private Node leftChild;
    private Node rightChild;

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void display() {
        person.display();
    }
}

public class Tree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            int id = current.getPerson().getId();
            if (id == key) break;
            if (key > id) {
                current = current.getRightChild();
            } else {
                current = current.getLeftChild();
            }
        }
        return current;
    }

    public void insert(Person person) {
        int key = person.getId();
        Node node = new Node(person);
        if(root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while(true) {
                parent = current;
                if(key < current.getPerson().getId()) {
                    current = current.getLeftChild();
                    if(current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if(current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    public Node min() {
        Node current = root;
        Node last = root;
        while (current != null) {
            current = current.getLeftChild();
            if (current == null) break;
            last = current;
        }
        return last;
    }

    public Node max() {
        Node current = root;
        Node last = root;
        while (current != null) {
            current = current.getRightChild();
            if (current == null) break;
            last = current;
        }
        return last;
    }

    public void inOrder(Node rootNode) {
        if(rootNode != null) {
            inOrder(rootNode.getLeftChild());
            rootNode.display();
            inOrder(rootNode.getRightChild());
        }
    }

    public void directOrder(Node rootNode) {
        if(rootNode != null) {
            rootNode.display();
            inOrder(rootNode.getLeftChild());
            inOrder(rootNode.getRightChild());
        }
    }

    public void backOrder(Node rootNode) {
        if(rootNode != null) {
            inOrder(rootNode.getLeftChild());
            inOrder(rootNode.getRightChild());
            rootNode.display();
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        
        boolean isLeftChild = true;

        while(current.getPerson().getId() != key) {
            if(key < current.getPerson().getId()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if(current == null)
                return false;
        }

        Node leftChild = current.getLeftChild();
        Node rightChild = current.getRightChild();
        if(leftChild == null && rightChild == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if(rightChild == null) {
            if(current == null) {
                root = leftChild;
            } else if(isLeftChild) {
                parent.setLeftChild(leftChild);
            } else {
                parent.setRightChild(leftChild);
            }
        } else if(leftChild == null) {
            if(current == null) {
                root = rightChild;
            } else if(isLeftChild) {
                parent.setLeftChild(rightChild);
            } else {
                parent.setRightChild(rightChild);
            }
        } else {
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
               parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(leftChild);
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.getRightChild();

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if(successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;
    }
}